package com.xmu.wowoto.wowomall.dao;

import com.xmu.wowoto.wowomall.domain.Order;
import com.xmu.wowoto.wowomall.domain.OrderItem;
import com.xmu.wowoto.wowomall.domain.Product;
import com.xmu.wowoto.wowomall.mapper.OrderItemMapper;
import com.xmu.wowoto.wowomall.mapper.OrderMapper;
import com.xmu.wowoto.wowomall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Repository
public class OrderDao {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private GoodsService goodsService;

    /**
     * 新增订单，包括订单明细
     * @param order 订单
     * @return 新订单，带id的
     */
    public Order addOrder(Order order){
        orderMapper.addOrder(order);
        order.setItemsOrderId();
        orderItemMapper.addOrderItems(order.getOrderItemList());

        return order;
    }

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
     * @param sort      排序
     * @param orderWay     正序或逆序
     * @return 订单列表
     */
    public List<Order> getOrdersByStatusCode(Integer userId, Integer statusCode, Integer page, Integer limit, String sort, String orderWay)
    {
        page = page - 1;
        List<Order> orders = orderMapper.getOrdersByStatusCode(userId, statusCode, page, limit,sort,orderWay);
        for (Order order: orders) {
            List<OrderItem> orderItems = orderItemMapper.getOrderItemsByOrderId(order.getId());
            for (OrderItem orderItem: orderItems){
                Product product = goodsService.getProductById(orderItem.getId());
                orderItem.setProduct(product);

            }

            order.setOrderItemList(orderItems);
        }
        return orders;
    }

    /**
     * 根据订单查询信息返回订单对象
     * @param orderId 订单ID：
     * @return 订单
     */
    public Order getOrderByOrderId(Integer orderId)
    {
        Order order = orderMapper.getOrderByOrderId(orderId);
        List<OrderItem> orderItems = orderItemMapper.getOrderItemsByOrderId(orderId);
        for (OrderItem orderItem: orderItems){
            Product product = goodsService.getProductById(orderItem.getId());
            orderItem.setProduct(product);

        }
        order.setOrderItemList(orderItems);
        return order;
    }

    /**
     * 修改订单状态
     * @param order 订单
     * @return 修改数量
     */
    public Integer updateOrder(Order order){
        return orderMapper.updateOrderSelective(order);
    }

    /**
     * 修改订单商品状态
     * @param orderItem 订单
     * @return 修改数量
     */
    public Integer updateOrderItem(OrderItem orderItem){
        return orderItemMapper.updateOrderItemSelective(orderItem);
    }



}
