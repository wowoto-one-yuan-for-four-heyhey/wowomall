package com.xmu.wowoto.wowomall.controller.vo;


import com.xmu.wowoto.wowomall.domain.WowoAddress;

import java.util.List;

public class SubmitOrderVo {
    /**
     *  用户在购物车中选中项目的id
     */
    private List<Integer> cartItemIds;
    /**
     * 配送的地址
     */
    private WowoAddress wowoAddress;
    /**
     * 优惠卷id
     */
    private Integer couponId;
    /**
     * 订单留言
     */
    private String message = "";

    @Override
    public String toString() {
        return "SubmitOrderVo{" +
                "cartItemIds=" + cartItemIds +
                ", wowoAddress=" + wowoAddress +
                ", couponId=" + couponId +
                ", message='" + message + '\'' +
                '}';
    }

    public List<Integer> getCartItemIds() {
        return cartItemIds;
    }

    public void setCartItemIds(List<Integer> cartItemIds) {
        this.cartItemIds = cartItemIds;
    }

    public WowoAddress getWowoAddress() {
        return wowoAddress;
    }

    public void setWowoAddress(WowoAddress wowoAddress) {
        this.wowoAddress = wowoAddress;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
