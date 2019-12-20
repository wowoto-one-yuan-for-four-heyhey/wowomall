package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.CartItem;
import com.xmu.wowoto.wowomall.domain.Order;
import com.xmu.wowoto.wowomall.domain.OrderItem;
import com.xmu.wowoto.wowomall.domain.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Service
public interface OrderService {

    /**
     * 提交订单
     * @param order 新订单
     * @param cartItems 购物车中加入订单的货品
     * @return 新产生的订单
     */
    Order submit(Order order, List<CartItem> cartItems);

    /**
     * 获取用户订单列表
     *
     * @param userId   用户ID
     * @param statusCode 订单信息
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    List<Order> getOrders(Integer userId, Integer statusCode, Integer page, Integer limit);

    /**
     * 获取用户特定订单详情
     * @param orderId 订单ID
     * @return 订单详细
     */
    Order getOrder(Integer orderId);

    /**
     * 订单发货修改订单状态
     *
     * @param order
     * @return 修改列数
     */
    Order shipOrder(Order order);

    /**
     * 取消订单
     *
     * @param order
     * @return 操作结果
     */
    Order cancelOrder(Order order);

    /**
     * 删除订单
     *
     * @param order
     * @return 操作结果
     */
    Order deleteOrder(Order order);




    OrderItem refundOrderItem(OrderItem orderItem, Order order);

    /**
     * 确认收货
     *
     * @param order
     * @return 订单操作结果
     */
    Order confirm(Order order);

    /**
     * 得到一项orderItem
     * @param orderItemId
     * @return
     */
    OrderItem getOrderItem(Integer orderItemId);

    /**
     * 修改订单状态为支付
     * @param oneOrder
     * @return
     */
    HashMap<String,Integer> payOrder(Order oneOrder);

    /**
     * 获取团购订单数量
     * @param goodId
     * @param startTime
     * @param endTime
     * @return
     */
    Integer getGrouponOrdersNum(Integer goodId, LocalDateTime startTime,LocalDateTime endTime);

    /**
     * 团购订单退款
     * @param goodId
     * @param startTime
     * @param endTime
     * @return
     */
    List<Payment> refundGrouponOrders(Integer goodId, LocalDateTime startTime, LocalDateTime endTime, Double rate);

    /**
     * 预售订单退款
     * @param goodId
     * @param startTime
     * @param endTime
     * @return
     */
    List<Payment> refundPresaleOrders(Integer goodId, LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 更新一项order
     * @param order
     * @return
     */
     Integer updateOrder(Order order);

    /**
     * 管理员获取订单
     * @param userId
     * @param orderSn
     * @param orderStatusArray
     * @param page
     * @param limit
     * @return
     */
    public List<Order> getOrdersByStatusCodesAndOrderSn(Integer userId,String orderSn,
                                                        List<Short> orderStatusArray,
                                                        Integer page, Integer limit);

    /**
     * 判断一个payment是否可支付
     * @param payment
     * @return
     */
    boolean judgePaymentAccessible(Payment payment);

    /**
     * 取消超时订单
     * @param order
     * @return
     */
    Order autoCancelOrder(Order order);
}
