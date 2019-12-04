package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.entity.Coupon;

public class WowoCoupon extends Coupon {

    private WowoCouponRule wowoCouponRule;

    public Coupon getCoupon(){
        return this;
    }
}
