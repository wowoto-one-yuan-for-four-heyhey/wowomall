package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.domain.Po.OrderPo;
import com.xmu.wowoto.wowomall.util.Common;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:订单对象
 * @Data:Created in 14:50 2019/12/11
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Order extends OrderPo {
    private Address addressObj;
    private User user;
    private List<OrderItem> orderItemList;
    private Integer couponId;

    public enum StatusCode{
        NOT_PAYED(0),
        NOT_PAYED_CANCELED(1),
        NOT_PAYED_SYSTEM_CANCELED(2),
        PAYED(3),
        PAYED_CANCELED(4),
        SHIPPED(5),
        SHIPPED_CONNFIEM(6),
        SHIPPED_SYSTEM_CONNFIEM(7),
        COMMENTED(8);

        private final int value;

        StatusCode(int value) { this.value = value; }

        public int getValue() { return value; }
    }

    public Order(User user, Address address){
        this.setUser(user);
        this.setUserId(user.getId());
        this.setAddressObj(address);
        this.setAddress(address);
        this.setMobile(address.getMobile());
        this.setConsignee(address.getConsignee());
        this.setOrderSn("P" + Common.getRandomNum(1));
        this.setStatusCode(StatusCode.NOT_PAYED.value);
    }

    /**
     * 把addressObj存成address
     */
    public void setAddress(Address address){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(address.getProvince());
        stringBuilder.append(address.getCounty());
        stringBuilder.append(address.getCity());
        stringBuilder.append(address.getAddressDetail());
        stringBuilder.append(" ");
        stringBuilder.append(address.getConsignee());
        stringBuilder.append(" ");
        stringBuilder.append(address.getPostalCode());
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


    /**
     * 计算订单的成交价格
     */
    public void cacuDealPrice(){
        BigDecimal dealTotal=BigDecimal.ZERO;

        //调用此函数前已调用过cacuCouponPrice
        //首先计算使用优惠券后的商品价格总和
        Coupon coupon =new Coupon();
        if(coupon!=null){
            this.cacuCouponPrice();
        }
        for(OrderItem oneItem:this.orderItemList){
            dealTotal=dealTotal.add(oneItem.getDealPrice().multiply(BigDecimal.valueOf(oneItem.getNumber())));
        }

        //减去返点减免
        BigDecimal rebatePrice =this.getRebatePrice();
        if(rebatePrice ==null){
            this.cacuRebatePrice();
            rebatePrice =this.getRebatePrice();
        }
        dealTotal=dealTotal.subtract(rebatePrice);

        //加上运费
        BigDecimal freightPrice = this.getFreightPrice();
        if(freightPrice == null){
            this.cacuFreightPrice();
            freightPrice = this.getFreightPrice();
        }
        dealTotal = dealTotal.add(freightPrice);

        this.setIntegralPrice(dealTotal);

    }
    /**
     * 计算订单的运费
     */
    public void cacuFreightPrice(){ }

    /**
     * 计算订单的优惠券费用
     */
    public void cacuCouponPrice(){ }

    /**
     * 计算订单的返点费用
     */
    public void cacuRebatePrice(){ }

    public void setItemsOrderId(){
        for (OrderItem orderItem: orderItemList){
            orderItem.setOrderId(this.getId());
        }
    }
}
