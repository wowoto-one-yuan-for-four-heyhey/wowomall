package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.domain.Po.OrderPo;
import com.xmu.wowoto.wowomall.util.Common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:订单对象
 * @Data:Created in 14:50 2019/12/11
 **/
public class Order extends OrderPo {
    private Address addressObj;
    private User user;
    private List<OrderItem> orderItemList;
    private Integer couponId;
    private List<Payment> paymentList;

    public Address getAddressObj() {
        return this.addressObj;
    }

    public User getUser() {
        return this.user;
    }

    public List<OrderItem> getOrderItemList() {
        return this.orderItemList;
    }

    public Integer getCouponId() {
        return this.couponId;
    }

    public List<Payment> getPaymentList() {
        return this.paymentList;
    }

    public void setAddressObj(Address addressObj) {
        this.addressObj = addressObj;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Order)) return false;
        final Order other = (Order) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        final Object this$addressObj = this.getAddressObj();
        final Object other$addressObj = other.getAddressObj();
        if (this$addressObj == null ? other$addressObj != null : !this$addressObj.equals(other$addressObj))
            return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$orderItemList = this.getOrderItemList();
        final Object other$orderItemList = other.getOrderItemList();
        if (this$orderItemList == null ? other$orderItemList != null : !this$orderItemList.equals(other$orderItemList))
            return false;
        final Object this$couponId = this.getCouponId();
        final Object other$couponId = other.getCouponId();
        if (this$couponId == null ? other$couponId != null : !this$couponId.equals(other$couponId)) return false;
        final Object this$paymentList = this.getPaymentList();
        final Object other$paymentList = other.getPaymentList();
        if (this$paymentList == null ? other$paymentList != null : !this$paymentList.equals(other$paymentList))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Order;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $addressObj = this.getAddressObj();
        result = result * PRIME + ($addressObj == null ? 43 : $addressObj.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $orderItemList = this.getOrderItemList();
        result = result * PRIME + ($orderItemList == null ? 43 : $orderItemList.hashCode());
        final Object $couponId = this.getCouponId();
        result = result * PRIME + ($couponId == null ? 43 : $couponId.hashCode());
        final Object $paymentList = this.getPaymentList();
        result = result * PRIME + ($paymentList == null ? 43 : $paymentList.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Order(addressObj=" + this.getAddressObj() + ", user=" + this.getUser() + ", orderItemList=" + this.getOrderItemList() + ", couponId=" + this.getCouponId() + ", paymentList=" + this.getPaymentList() + ")";
    }

    public enum StatusCode{
        NOT_PAYED(0),
        NOT_PAYED_CANCELED(1),
        NOT_PAYED_SYSTEM_CANCELED(2),
        PAYED(3),
        PAYED_CANCELED(4),
        SHIPPED(5),
        SHIPPED_CONFIRM(6),
        SHIPPED_SYSTEM_CONFIRM(7),
        COMMENTED(8);

        private final int value;

        StatusCode(int value) { this.value = value; }

        public int getValue() { return value; }
    }

    public Order(){
        super();
    }

    public Order(User user, Address address){
        this.setUser(user);
        this.setUserId(user.getId());
        this.setAddressObj(address);
        this.setAddressString(address);
        this.setMobile(address.getMobile());
        this.setConsignee(address.getConsignee());
        this.setOrderSn("P" + Common.getRandomNum(1));
        this.setStatusCode(StatusCode.NOT_PAYED.value);
    }

    /**
     * 把addressObj存成address
     */
    public void setAddressString(Address address){
        StringBuilder stringBuilder = new StringBuilder();
        if(address.getProvince() != null)
            stringBuilder.append(address.getProvince());
        if(address.getCounty() != null)
            stringBuilder.append(address.getCounty());
        if(address.getCity() != null)
            stringBuilder.append(address.getCity());
        if(address.getAddressDetail() != null)
            stringBuilder.append(address.getAddressDetail());
        stringBuilder.append(" ");
        if(address.getConsignee() != null)
            stringBuilder.append(address.getConsignee());
        stringBuilder.append(" ");
        if(address.getPostalCode() != null)
            stringBuilder.append(address.getPostalCode());
        this.setAddress(stringBuilder.toString());
    }



    /**
     * 计算订单的商品总价
     */
    public void cacuGoodsPrice(){
        BigDecimal total = BigDecimal.ZERO;
        for(OrderItem orderItem: this.orderItemList){
            total = total.add(orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getNumber())));
        }
        this.setGoodsPrice(total);
    }

    public void cacuIntegral(){
        BigDecimal integral = BigDecimal.ZERO;
        integral = integral.add(this.getGoodsPrice());
        if(this.getFreightPrice() != null)
            integral = integral.add(this.getFreightPrice());
        if(this.getCouponPrice() != null)
            integral = integral.subtract(this.getCouponPrice());
        if(this.getRebatePrice() != null)
            integral = integral.subtract(this.getRebatePrice());
        this.setIntegralPrice(integral);

        if(this.getRebatePrice() != null && this.getRebatePrice().compareTo(BigDecimal.ZERO) != 0)
            this.distributePrice();
    }

    public void cacuPayment(){
        if(this.paymentList != null){
            //预售订单
            BigDecimal deposit = this.paymentList.get(0).getActualPrice();
            deposit = deposit.add(this.getFreightPrice());
            this.paymentList.get(0).setActualPrice(deposit);
        }else {
            //团购、普通订单
            this.paymentList = new ArrayList<>();
            Payment payment = new Payment(this);
            BigDecimal price = this.getGoodsPrice();
            if(this.getFreightPrice() != null)
                price = price.add(this.getFreightPrice());
            if (this.getCouponPrice() != null)
                price = price.subtract(this.getCouponPrice());
            if(this.getRebatePrice() != null)
                price = price.subtract(this.getRebatePrice());
            payment.setActualPrice(price);
            payment.setEndTime(LocalDateTime.now().plusMinutes(30));
            payment.setBeginTime(LocalDateTime.now());
            payment.setPayChannel(0);

            this.paymentList.add(payment);
        }
    }

    public void setItemsOrderId(){
        for (OrderItem orderItem: orderItemList){
            orderItem.setOrderId(this.getId());
        }
    }

    public void distributePrice(){
        BigDecimal totalRebate = this.getRebatePrice();

        BigDecimal totalDealPrice = BigDecimal.ZERO;
        for(OrderItem orderItem: orderItemList){
            BigDecimal rebate = orderItem.getDealPrice().divide(this.getGoodsPrice()).multiply(totalRebate);
            orderItem.setDealPrice(orderItem.getDealPrice().subtract(rebate));
            totalDealPrice.add(orderItem.getDealPrice());
        }

        BigDecimal error = totalDealPrice.subtract(totalRebate.multiply(BigDecimal.valueOf(1.0)).setScale(2, RoundingMode.HALF_UP));
        if(error.compareTo(BigDecimal.ZERO) != 0){
            OrderItem first = orderItemList.get(0);
            BigDecimal dealPrice = first.getDealPrice().add(error);
            first.setDealPrice(dealPrice);
        }
    }

}
