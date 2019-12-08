package com.xmu.wowoto.wowomall.mapper;

import com.xmu.wowoto.wowomall.domain.WowoOrder;
import com.xmu.wowoto.wowomall.domain.WowoOrderItem;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderItemMapper {

    /**
     * 新增一系列订单商品
     * @param wowoOrderItems 订单对象
     * @return 行数
     */
    Integer addOrderItems(List<WowoOrderItem> wowoOrderItems);

    /**
     * 根据订单Id信息返回订单物品列表
     * @param orderId   订单ID
     * @return 订单物品列表
     */
    List<WowoOrderItem> getOrderItemsByOrderId(int orderId);

    /**
     * 修改订单商品
     * @param wowoOrderItem 订单
     * @return 修改数目
     */
    Integer updateOrderItemSelective(WowoOrderItem wowoOrderItem);
}
