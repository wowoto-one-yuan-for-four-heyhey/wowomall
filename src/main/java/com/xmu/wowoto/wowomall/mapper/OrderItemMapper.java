package com.xmu.wowoto.wowomall.mapper;

import com.xmu.wowoto.wowomall.domain.OrderItem;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

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
}
