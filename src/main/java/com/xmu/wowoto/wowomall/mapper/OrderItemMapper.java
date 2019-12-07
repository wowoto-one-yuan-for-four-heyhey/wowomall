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
     * 根据订单Id信息返回订单物品列表
     * @param orderId   订单ID
     * @return 订单物品列表
     */
    List<WowoOrderItem> getOrderItemsByOrderId(int orderId);
}
