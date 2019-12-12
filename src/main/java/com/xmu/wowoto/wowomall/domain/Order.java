package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.domain.po.OrderPo;
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
        NOT_PAYED(1),
        PAYED(2),
        NOT_TAKEN(3),
        NOT_COMMENTED(4),
        FINISHED(5),
        REFUND(6),
        EXCHANGE(7);

        private final int value;

        StatusCode(int value) { this.value = value; }

        public int getValue() { return value; }
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
        Coupon wowoCoupon=this.getWowoCoupon();
        if(wowoCoupon!=null){
            this.cacuCouponPrice();
        }
        for(WowoOrderItem oneItem:this.wowoOrderItems){
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
        if(freightPrice ==null){
            this.cacuFreightPrice();
            freightPrice = this.getFreightPrice();
        }
        dealTotal=dealTotal.add(freightPrice);

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
