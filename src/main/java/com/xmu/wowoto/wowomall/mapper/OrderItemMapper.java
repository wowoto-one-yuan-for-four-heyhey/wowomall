package com.xmu.wowoto.wowomall.mapper;

import com.xmu.wowoto.wowomall.domain.OrderItem;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Mapper
public interface OrderItemMapper {

    /**
     * 新增一系列订单商品
     * @param orderItems 订单对象
     * @return 行数
     */
    Integer addOrderItems(List<OrderItem> orderItems);

    /**
     * 根据订单Id信息返回订单物品列表
     * @param orderId   订单ID
     * @return 订单物品列表
     */
    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    /**
     * 修改订单商品
     * @param orderItem 订单
     * @return 修改数目
     */
    Integer updateOrderItemSelective(OrderItem orderItem);

    /**
     * 根据id返回一项订单详情
     * @param OrderItemId
     * @return
     */
    OrderItem getOrderItemById(Integer OrderItemId);

    /**
     * 根据状态码和日期获取item
     * @param status
     * @param start
     * @param end
     * @return
     */
    List<OrderItem> getOrderItemByStatus(Integer status, LocalDateTime start, LocalDateTime end);

    /**
     * 找出固定时间范围内的订单
     * @param start
     * @param end
     * @return
     */
    List<OrderItem> getOrderItemByTimeLimit(LocalDateTime start, LocalDateTime end);
}
