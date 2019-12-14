package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.dao.OrderDao;
import com.xmu.wowoto.wowomall.domain.CartItem;
import com.xmu.wowoto.wowomall.domain.Order;
import com.xmu.wowoto.wowomall.domain.OrderItem;
import com.xmu.wowoto.wowomall.service.CartService;
import com.xmu.wowoto.wowomall.service.GoodsService;
import com.xmu.wowoto.wowomall.service.OrderService;
import com.xmu.wowoto.wowomall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.xmu.wowoto.wowomall.util.ResponseCode.*;

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

            /**
             * 扣减库存
             */
            boolean enough = true;
            for (OrderItem orderItem: order.getOrderItemList()){

            }

            order.cacuGoodsPrice();
            order.cacuDealPrice();

            //添加订单
            newOrder = orderDao.addOrder(order);

            //添加一条未支付的payment
        }




        return newOrder;
    }

    /**
     * 用CartItem构造OrderItem
     * @param order 订单对象
     * @param cartItems 购物车对象列表
     */
    private Boolean createOrderItemFromCartItem(Order order, List<CartItem> cartItems) {
        List<OrderItem> orderItems = new ArrayList<>(cartItems.size());
        for (CartItem cartItem: cartItems){
            if(goodsService.deductStock(cartItem.getProductId(), cartItem.getNumber())){
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
     * @param orderId 订单ID
     * @param userId 用户ID
     * @return 订单列表
     */
    @Override
    public Object refundOrder(Integer userId,Integer orderId){
        /*xbb*/
        Order order = orderDao.getOrderByOrderId(orderId);
        if(order == null){ return  ResponseUtil.fail(ORDER_INVALID.getCode(),ORDER_INVALID.getMessage()); }
        if(Order.StatusCode.PAYED_CANCELED.getValue() >= order.getStatusCode()){
            order.setStatusCode(Order.StatusCode.PAYED_CANCELED.getValue());
            List<OrderItem> orderItems= order.getOrderItemList();
            for(OrderItem item : orderItems){
                Integer itemId = item.getOrderId();
                // 对item的操作
            }

            Integer status = orderDao.updateOrder(order);
            if(status == 1) {
                //对用户 钱进行更新
                // 对价格进行更新

                //return ResponseUtil.ok(updateNum);
                return ResponseUtil.ok();
            }
            else{
                return ResponseUtil.fail(ORDER_INVALID.getCode(),ORDER_INVALID.getMessage());
            }
        }
       return  ResponseUtil.fail();
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
                if(re!=1) {
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
             * @param userId   用户ID
             * @param orderId  订单ID
             * @return 操作结果
             */
    @Override
    public Object cancelOrder(Integer userId, Integer orderId){
        Order wowoOrder = orderDao.getOrderByOrderId(orderId);
        if(null != wowoOrder){
            wowoOrder.setStatusCode(Order.StatusCode.NOT_PAYED_CANCELED.getValue());
        }
        return true;
    }

    /**
     * 删除订单
     *
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 操作结果
     */
    @Override
    public Object deleteOrder(Integer userId, Integer orderId){
        Order order = orderDao.getOrderByOrderId(orderId);
        if(null != order){
            for(OrderItem orderItem: order.getOrderItemList()){
                orderItem.setBeDeleted(true);
                if(orderDao.updateOrderItem(orderItem) < 1){
                    return ResponseUtil.fail(ORDER_INVALID.getCode(),ORDER_INVALID.getMessage());
                }
            }
            order.setBeDeleted(true);
            return ResponseUtil.ok(orderDao.updateOrder(order));
        }else {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode(),ORDER_UNKNOWN.getMessage());
        }
    }

    /**
     * 订单发货
     *
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 操作结果
     */
    @Override
    public Object shipOrder(Integer userId,Integer orderId){
        Order order = orderDao.getOrderByOrderId(orderId);
        if(order == null){
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode(),ORDER_UNKNOWN.getMessage());
        }
        if(Order.StatusCode.SHIPPED.getValue() >= order.getStatusCode()) {
            order.setStatusCode(Order.StatusCode.SHIPPED.getValue());
            order.setShipTime(LocalDateTime.now());
            Integer updateNum = orderDao.updateOrder(order);
            if(updateNum == 1){
                return ResponseUtil.ok(updateNum);
            }else {
                return ResponseUtil.fail(ORDER_INVALID.getCode(),ORDER_INVALID.getMessage());
            }
        } else {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode(),ORDER_INVALID_OPERATION.getMessage());
        }
    }

    /**
     * 订单确认
     *
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 操作结果
     */
    @Override
    public Object confirm(Integer userId,Integer orderId){
        Order order = orderDao.getOrderByOrderId(orderId);
        if(order == null){
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode(),ORDER_UNKNOWN.getMessage());
        }
        if(order.getStatusCode() == Order.StatusCode.SHIPPED.getValue()) {
            order.setStatusCode(Order.StatusCode.SHIPPED_CONNFIEM.getValue());
            order.setConfirmTime(LocalDateTime.now());
            Integer updateNum = orderDao.updateOrder(order);
            if(updateNum == 1){
                return ResponseUtil.ok(updateNum);
            }else {
                return ResponseUtil.fail(ORDER_INVALID.getCode(),ORDER_INVALID.getMessage());
            }
        } else {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode(),ORDER_INVALID_OPERATION.getMessage());
        }
    }



    /**
     * 评价订单
     *
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 操作结果
     */
    @Override
    public Object comment(Integer userId,Integer orderId){
        Order order = orderDao.getOrderByOrderId(orderId);
        if(order == null){
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode(),ORDER_UNKNOWN.getMessage());
        }
        if(order.getStatusCode() == Order.StatusCode.SHIPPED_CONNFIEM.getValue()) {
            order.setStatusCode(Order.StatusCode.COMMENTED.getValue());
            order.setConfirmTime(LocalDateTime.now());
            Integer updateNum = orderDao.updateOrder(order);
            if(updateNum == 1){
                return ResponseUtil.ok(updateNum);
            }else {
                return ResponseUtil.fail(ORDER_INVALID.getCode(),ORDER_INVALID.getMessage());
            }
        } else {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode(),ORDER_INVALID_OPERATION.getMessage());
        }
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


    @Override
    public Integer getGrouponNum(Integer goodId){
        Integer num = orderDao.getGrouponNumById(goodId);
        return num;

    }
}


