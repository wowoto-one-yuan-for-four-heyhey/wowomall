package com.xmu.wowoto.wowomall.domain;

import java.time.LocalDateTime;

public class WowoCoupon extends Coupon {

    private WowoCouponRule wowoCouponRule;

    /**
     * 判断某个优惠卷是否能用
     * @return
     */
    public boolean isReadyToUse() {
        LocalDateTime now = LocalDateTime.now();
        return (this.getBeginTime().isBefore(now) &&
                this.getEndTime().isAfter(now));
    }

    /**
     * 获得优惠的费用
     *
     * @param wowoOrder 订单
     * @return 优惠的费用
     */
    public void cacuCouponPrice(WowoOrder wowoOrder) {
        if (this.isReadyToUse()){
            this.getWowoCouponRule().cacuCouponPrice(wowoOrder, this.getCouponSn());
        }
    }

    public WowoCouponRule getWowoCouponRule() {
        return wowoCouponRule;
    }

    public void setWowoCouponRule(WowoCouponRule wowoCouponRule) {
        this.wowoCouponRule = wowoCouponRule;
    }
}
