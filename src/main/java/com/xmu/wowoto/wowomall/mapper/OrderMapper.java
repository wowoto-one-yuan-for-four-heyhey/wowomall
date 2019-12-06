package com.xmu.wowoto.wowomall.mapper;

import com.xmu.wowoto.wowomall.domain.WowoOrder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {
    /**
     * 根据订单查询信息返回订单对象
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
     * @return 订单列表
     */
    List<WowoOrder> getOrdersByStatusCode(Integer userId, Integer statusCode, Integer page, Integer limit, String sort, String order);

    /**
     * 根据订单查询信息返回订单对象
     * @param orderId 订单ID：

     * @return 订单
     */
    WowoOrder getOrderByOrderId(Integer userId, Integer orderId);

    WowoOrder updateOrderStatusById(Integer orderId,Integer statusCode);




    WowoOrder getOrderByOrderId(Integer orderId);
}
