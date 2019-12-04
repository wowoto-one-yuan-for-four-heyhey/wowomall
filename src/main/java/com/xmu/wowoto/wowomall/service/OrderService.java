package com.xmu.wowoto.wowomall.service;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    /**
     * 获取用户订单列表
     *
     * @param userId   用户ID
     * @param statusCode 订单信息
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    public Object getOrders(Integer userId, Integer statusCode, Integer page, Integer limit,String sort,String order);

}
