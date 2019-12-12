package com.xmu.wowoto.wowomall.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xmu.wowoto.wowomall.entity.Order;
import com.xmu.wowoto.wowomall.entity.OrderItem;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Alias("WowoOrder")
@JsonSerialize(as = Order.class)
public class WowoOrder extends com.xmu.wowoto.wowomall.entity.Order {


    public enum STATUSCODE{
        NOT_PAYED(1),
        PAYED(2),
        NOT_TAKEN(3),
        NOT_COMMENTED(4),
        FINISHED(5),
        REFUND(6),
        EXCHANGE(7);

        private final int value;

        STATUSCODE(int value)
        {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private WowoUser wowoUser;

    private WowoCoupon wowoCoupon;

    private List<WowoOrderItem> wowoOrderItems;

    private WowoAddress wowoAddress;

    /**
     * 计算订单的商品总价
     */
    public void cacuGoodsPrice(){
        BigDecimal total = BigDecimal.ZERO;
        for(WowoOrderItem oneItem:this.wowoOrderItems){
            total=total.add(oneItem.getPrice().multiply(BigDecimal.valueOf(oneItem.getNumber())));
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
        WowoCoupon wowoCoupon=this.getWowoCoupon();
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
    public void cacuFreightPrice(){

    }

    /**
     * 计算订单的优惠券费用
      */
    public void cacuCouponPrice(){

    }

    /**
     * 计算订单的返点费用
     */
    public void cacuRebatePrice(){

    }



    public void setItemsOrderId(){
        for (WowoOrderItem wowoOrderItem: this.getWowoOrderItems()){
            wowoOrderItem.setOrderId(this.getId());
        }
    }

    public WowoUser getWowoUser() {
        return wowoUser;
    }

    public void setWowoUser(WowoUser wowoUser) {
        this.wowoUser = wowoUser;
    }

    public List<WowoOrderItem> getWowoOrderItems() {
        return wowoOrderItems;
    }

    public void setWowoOrderItems(List<WowoOrderItem> wowoOrderItems) {
        this.wowoOrderItems = wowoOrderItems;
    }

    public WowoAddress getWowoAddress() {
        return wowoAddress;
    }

    public void setWowoAddress(WowoAddress wowoAddress) {
        this.wowoAddress = wowoAddress;
    }

    public WowoCoupon getWowoCoupon() {
        return wowoCoupon;
    }

    public void setWowoCoupon(WowoCoupon wowoCoupon) {
        this.wowoCoupon = wowoCoupon;
    }
}