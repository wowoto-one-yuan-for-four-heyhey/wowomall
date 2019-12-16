package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Coupon;
import com.xmu.wowoto.wowomall.domain.Order;
import org.springframework.stereotype.Service;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Service
public interface DiscountService {
    /**
     * 算价格
     *
     * @param order   订单详情
     */
    Order caculatePrice(Order order);
}
