package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.WowoCoupon;
import org.springframework.stereotype.Service;

@Service
public interface CouponService {

    /**
     * 获取指定ID的优惠券
     *
     * @param couponId   优惠券ID
     */
    public WowoCoupon findCouponById(String couponId);
}
