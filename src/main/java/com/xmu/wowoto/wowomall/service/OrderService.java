package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.CartItem;
import com.xmu.wowoto.wowomall.domain.Order;
import com.xmu.wowoto.wowomall.domain.OrderItem;
import org.springframework.stereotype.Service;

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
     * @param wowoOrder 新订单
     * @param wowoCartItems 购物车中加入订单的货品
     * @return 新产生的订单
     */
    public Order submit(Order wowoOrder, List<CartItem> wowoCartItems);

    /**
     * 获取用户订单列表
     *
     * @param userId   用户ID
     * @param statusCode 订单信息
     * @param page     分页页数
     * @param limit     分页大小
     * @param sort      排序
     * @param order     正序/逆序
     * @return 订单列表
     */
    public List<Order> getOrders(Integer userId, Integer statusCode, Integer page, Integer limit, String sort, String order);

    /**
     * 获取用户特定订单详情
     * @param orderId 订单ID
     * @return 订单详细
     */
    public Order getOrder(Integer orderId);

    /**
     * 订单发货修改订单状态
     *
     * @param userId 用户ID
     * @param orderId 订单ID
     * @return 修改列数
     */
    public Object shipOrder(Integer userId,Integer orderId);

    /**
     * 取消订单
     *
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 操作结果
     */
    public Object cancelOrder(Integer userId, Integer orderId);

    /**
     * 删除订单
     *
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 操作结果
     */
    public Object deleteOrder(Integer userId, Integer orderId);

    /**
     * 订单修改订单状态为退款(管理员操作)
     *
     * @param orderId 订单ID
     * @param userId 用户ID
     * @return 订单详细
     */
    public Object refundOrder(Integer userId,Integer orderId);

    /**
     * 提供给支付模块修改订单状态->支付成功  (供paymentService调用)"
     * @param order
     * statusCode PAYED
     * @return 是否成功
     */
    public HashMap<String,Integer> payOrder(Order order);


    /**
     * 确认收货
     *
     * @param orderId 订单ID
     * @param userId 用户ID
     * @return 订单操作结果
     */
    public Object confirm(Integer userId,Integer orderId);


    /**
     * 评价
     *
     * @param orderId 订单ID
     * @param userId 用户ID
     * @return 订单操作结果
     */
    public Object comment(Integer userId,Integer orderId);

    /**
     * 得到一项orderItem
     * @param orderItemId
     * @return
     */
    public OrderItem getOrderItem(Integer orderItemId);


    public Integer getGrouponNum(Integer goodId);
}
