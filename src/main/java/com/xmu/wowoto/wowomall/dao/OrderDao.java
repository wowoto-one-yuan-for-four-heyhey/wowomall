package com.xmu.wowoto.wowomall.dao;

import com.xmu.wowoto.wowomall.domain.Order;
import com.xmu.wowoto.wowomall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDao {

    @Autowired
    private OrderMapper orderMapper;
    /**
     * 获取用户订单列表
     *
     * @param userId   用户ID
     * @param statusCode 订单信息：
     *                 1未付款，
     *                 2未发货，
     *                 3未收获，
     *                 4未评价，
     *                 5已完成订单，
     *                 6退货订单，
     *                 7换货订单
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    public List<Order> getOrdersByStatusCode(Integer userId, Integer statusCode, Integer page, Integer limit,String sort,String order)
    {
        List<Order> orderList=orderMapper.getOrdersByStatusCode(userId, statusCode, page, limit,sort,order);
        return orderList;
    }
}
