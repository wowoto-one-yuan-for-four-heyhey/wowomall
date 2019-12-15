package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.domain.Coupon;
import com.xmu.wowoto.wowomall.service.DiscountService;
import com.xmu.wowoto.wowomall.service.RemoteDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    RemoteDiscountService remoteDiscountService;

    @Override
    public Coupon findCouponById(Integer couponId) {
        return new Coupon();
    }
}
