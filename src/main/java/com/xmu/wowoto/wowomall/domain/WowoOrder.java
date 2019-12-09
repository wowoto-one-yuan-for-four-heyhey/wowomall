package com.xmu.wowoto.wowomall.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xmu.wowoto.wowomall.entity.Order;
import org.apache.ibatis.type.Alias;

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
     * 计算订单的成交价格
     */
    public void cacuDealPrice(){
        //目前设计只支持一个订单中同类优惠卷只能使用一张优惠卷，一个货品只能选择使用一张优惠卷
        WowoCoupon wowoCoupon = this.getWowoCoupon();
        if (wowoCoupon != null) {
            wowoCoupon.cacuCouponPrice(this);
        }
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