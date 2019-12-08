package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.domain.WowoCoupon;
import com.xmu.wowoto.wowomall.service.CouponService;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    @Override
    public WowoCoupon findCouponById(Integer couponId) {
        return new WowoCoupon();
    }
}
