package com.xmu.wowoto.wowomall.dao;

import com.xmu.wowoto.wowomall.domain.Order;
import com.xmu.wowoto.wowomall.domain.OrderItem;
import com.xmu.wowoto.wowomall.domain.Product;
import com.xmu.wowoto.wowomall.mapper.OrderItemMapper;
import com.xmu.wowoto.wowomall.mapper.OrderMapper;
import com.xmu.wowoto.wowomall.service.GoodsService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
     * 订单状态
     * -1:全部订单
     * 0：订单生成,未支付
     * 1：下单后未支付，用户取消
     * 2：下单后未支付超时系统自动取消
     * 3：支付完成，商家未发货
     * 4：订单产生，已付款未发货，此时用户取消订单并取得退款（在发货前只要用户点取消订单，无需经过审核）
     * 5:商家发货，用户未确认
     * 6:用户确认收货
     * 7:用户没有确认收货超过一定时间，系统自动确认收货
     * 8:已评价
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    public List<Order> getOrdersByStatusCode(Integer userId, Integer statusCode, Integer page, Integer limit)
    {
        page=(page-1)*limit;
        List<Order> orders = orderMapper.getOrdersByStatusCode(userId, statusCode, page, limit);
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

    /**
     * 根据id拿到orderItem
     * @param orderItemId
     * @return
     */
    public OrderItem getOrderItemById(Integer orderItemId){
        return orderItemMapper.getOrderItemById(orderItemId);
    }


    /**
     * 查询团购订单数量
     * @param goodId
     * @return
     */
    public List<Order> getGrouponOrdersById(Integer goodId){
        List<Order> orders = new ArrayList<>();
        LocalDateTime nowTime = LocalDateTime.now().minusDays(8);
        orders.addAll(orderMapper.getGrouponOrdersById(goodId,Order.StatusCode.SHIPPED_CONNFIEM.getValue(),nowTime));
        orders.addAll(orderMapper.getGrouponOrdersById(goodId,Order.StatusCode.COMMENTED.getValue(),nowTime));
        orders.addAll(orderMapper.getGrouponOrdersById(goodId,Order.StatusCode.SHIPPED_SYSTEM_CONNFIEM.getValue(),nowTime));
        return orders;
    }

    public List<OrderItem> getRebatingOrderItems(){
        LocalDateTime start=LocalDateTime.now().minusDays(8);
        LocalDateTime end=LocalDateTime.now().minusDays(7);
        List<OrderItem> list =orderItemMapper.getOrderItemByTimeLimit(start,end);
        return list;
    }

}
