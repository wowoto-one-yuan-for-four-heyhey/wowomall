package com.xmu.wowoto.wowomall.dao;

import com.xmu.wowoto.wowomall.domain.WowoOrder;
import com.xmu.wowoto.wowomall.domain.WowoOrderItem;
import com.xmu.wowoto.wowomall.mapper.OrderItemMapper;
import com.xmu.wowoto.wowomall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDao {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
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
    public List<WowoOrder> getOrdersByStatusCode(Integer userId, Integer statusCode, Integer page, Integer limit, String sort, String order)
        {
            page=page-1;
            List<WowoOrder> wowoOrderList = orderMapper.getOrdersByStatusCode(userId, statusCode, page, limit,sort,order);
            return  wowoOrderList;
    }

    /**
     * 根据订单Id信息返回订单物品列表
     * @param orderId   订单ID
     * @return 订单物品列表
     */
    public List<WowoOrderItem> getOrderItemsByOrderId(int orderId)
    {
        List<WowoOrderItem> wowoOrderItemList = orderItemMapper.getOrderItemsByOrderId(orderId);
        return wowoOrderItemList;
    }

    /**
     * 根据订单查询信息返回订单对象
     * @param orderId 订单ID：
     * @return 订单
     */
    public WowoOrder getOrderByOrderId(Integer orderId)
    {
        return orderMapper.getOrderByOrderId(orderId);
    }
}
