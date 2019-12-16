package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.domain.Coupon;
import com.xmu.wowoto.wowomall.domain.Order;
import com.xmu.wowoto.wowomall.service.DiscountService;
import com.xmu.wowoto.wowomall.service.RemoteDiscountService;
import com.xmu.wowoto.wowomall.util.JacksonUtil;
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
    public Order caculatePrice(Order order) {
        String json = remoteDiscountService.caculatePrice(order);
        return JacksonUtil.parseObject(json, "data", Order.class);
    }
}
