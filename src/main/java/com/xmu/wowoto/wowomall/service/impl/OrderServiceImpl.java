package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.dao.OrderDao;
import com.xmu.wowoto.wowomall.domain.*;
import com.xmu.wowoto.wowomall.service.*;
import com.xmu.wowoto.wowomall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private FreightService freightService;

    @Autowired
    private LogisticsService logisticsService;

    /**
     * 获取用户订单列表
     *
     * @param userId   用户ID
     * @param statusCode 订单信息：
     *                 1未付款，
     *                 2未发货，
     *                 3未收货，
     *                 4未评价，
     *                 5已完成订单，
     *                 6退货订单，
     *                 7换货订单
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    @Override
    public List<Order> getOrders(Integer userId, Integer statusCode, Integer page, Integer limit)
    {
        List<Order> orders = orderDao.getOrdersByStatusCode(userId, statusCode, page, limit);
        return orders;
    }

    @Override
    public Order submit(Order order, List<CartItem> cartItems) {
        Order newOrder = null;
        if(this.createOrderItemFromCartItem(order, cartItems)){
            cartService.clearCartItem(cartItems);

            order.cacuGoodsPrice();

            //计算优惠促销价格
            order = discountService.caculatePrice(order);

            //计算运费
            order.setFreightPrice(freightService.caculateFreight(order));

            //物流单号
            order.setOrderSn(logisticsService.getShipSn());

            //最终计算
            order.cacuIntegral();

            //添加订单
            newOrder = orderDao.addOrder(order);

            //添加一条未支付的payment
            Payment payment = new Payment(order);
            paymentService.createPayment(payment);
        }

        return newOrder;
    }

    /**
     * 用CartItem构造OrderItem
     * @param order 订单对象
     * @param cartItems 购物车对象列表
     */
    private boolean createOrderItemFromCartItem(Order order, List<CartItem> cartItems) {
        List<OrderItem> orderItems = new ArrayList<>(cartItems.size());
        for (CartItem cartItem: cartItems){
            if(goodsService.deductStock(cartItem)){
                OrderItem orderItem = new OrderItem(cartItem);
                orderItems.add(orderItem);
            }else {
                return false;
            }
        }
        order.setOrderItemList(orderItems);
        return true;
    }

    /**
     * 获取用户特定订单详情
     *
     * @param orderId 订单ID
     * @return 订单列表
     */
    @Override
    public Order getOrder(Integer orderId)
    {
        Order order = orderDao.getOrderByOrderId(orderId);
        return order;
    }

    /**
     * 更改订单状态为退款(管理员操作)
     *
     * @param order
     * @return 订单列表
     */
    @Override
    public Order refundOrder(Order order){
        if(Order.StatusCode.PAYED_CANCELED.getValue() >= order.getStatusCode()){
            order.setStatusCode(Order.StatusCode.PAYED_CANCELED.getValue());
            List<OrderItem> orderItems= order.getOrderItemList();
            for(OrderItem item : orderItems){
                Integer itemId = item.getOrderId();
                // 对item的操作
            }

            orderDao.updateOrder(order);

                //对用户 钱进行更新
                // 对价格进行更新

                //return ResponseUtil.ok(updateNum);
        }
        return order;
    }

    /**
     * 提供给支付模块修改订单状态->支付成功  (供paymentService调用)"
     * @param oneOrder
     * @return 是否成功
     */
    @Override
    public HashMap<String,Integer> payOrder(Order oneOrder) {

        HashMap<String,Integer> result=new HashMap<>();
        if (Order.StatusCode.PAYED.getValue() > oneOrder.getStatusCode()) {
            List<OrderItem> orderItems = oneOrder.getOrderItemList();
            for (OrderItem item : orderItems) {
                item.setStatusCode(Order.StatusCode.PAYED.getValue());
                Integer re= orderDao.updateOrderItem(item);
                if(re != 1) {
                    result.put("orderItem",re);
                }
            }
            oneOrder.setPayTime(LocalDateTime.now());
            oneOrder.setStatusCode(Order.StatusCode.PAYED.getValue());
            Integer status = orderDao.updateOrder(oneOrder);
            result.put("order",status);
            return result;
        }
        result.put("order",-1);
        return result;
    }


    /**
     * 取消订单
     *
     * @param order
     * @return 操作结果
     */
    @Override
    public Order cancelOrder(Order order){
        order.setStatusCode(Order.StatusCode.NOT_PAYED_CANCELED.getValue());
        order.setEndTime(LocalDateTime.now());
        orderDao.updateOrder(order);
        return order;
    }

    /**
     * 删除订单
     *
     * @param order
     * @return 操作结果
     */
    @Override
    public Order deleteOrder(Order order){
        for(OrderItem orderItem: order.getOrderItemList()){
            orderItem.setBeDeleted(true);
            orderDao.updateOrderItem(orderItem);
        }
        order.setBeDeleted(true);
        order.setEndTime(LocalDateTime.now());
        orderDao.updateOrder(order);
        return order;
    }

    /**
     * 订单确认
     *
     * @param order
     */
    @Override
    public Order confirm(Order order){
        for(OrderItem orderItem: order.getOrderItemList()){
            orderItem.setStatusCode(OrderItem.StatusCode.CONFIRMED.getValue());
            orderDao.updateOrderItem(orderItem);
        }
        order.setStatusCode(Order.StatusCode.SHIPPED_CONFIRM.getValue());
        order.setConfirmTime(LocalDateTime.now());
        orderDao.updateOrder(order);
        return order;
    }

    /**
     * 订单发货
     *
     * @param order
     * @return 操作结果
     */
    @Override
    public Order shipOrder(Order order){
        for(OrderItem orderItem: order.getOrderItemList()){
            orderItem.setStatusCode(OrderItem.StatusCode.NOT_CONFIRMED.getValue());
            orderDao.updateOrderItem(orderItem);
        }
        order.setStatusCode(Order.StatusCode.SHIPPED.getValue());
        order.setShipTime(LocalDateTime.now());
        orderDao.updateOrder(order);
        return order;
    }

    /**
     * 得到一项orderItem
     * @param orderItemId
     * @return
     */
    @Override
    public OrderItem getOrderItem(Integer orderItemId)
    {
        return orderDao.getOrderItemById(orderItemId);
    }

    /**
     * 获取团购订单数量
     * @param goodId
     * @return
     */
    @Override
    public List<Order> getGrouponOrders(Integer goodId){
        return orderDao.getGrouponOrdersById(goodId);
    }
}


