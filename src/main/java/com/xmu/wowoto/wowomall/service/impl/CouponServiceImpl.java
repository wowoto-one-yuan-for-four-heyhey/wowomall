package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.service.CouponService;
import org.springframework.stereotype.Service;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Override
    public WowoCoupon findCouponById(Integer couponId) {
        return new WowoCoupon();
    }
}
