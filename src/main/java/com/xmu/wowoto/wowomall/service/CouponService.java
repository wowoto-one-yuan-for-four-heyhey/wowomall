package com.xmu.wowoto.wowomall.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Service
public interface CouponService {

    /**
     * 获取指定ID的优惠券
     *
     * @param couponId   优惠券ID
     */
    public WowoCoupon findCouponById(Integer couponId);
}
