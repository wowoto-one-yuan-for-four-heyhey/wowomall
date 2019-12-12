package com.xmu.wowoto.wowomall.mapper;

import com.xmu.wowoto.wowomall.domain.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Repository
@Mapper
public interface OrderMapper {

    /**
     * 新增一个订单
     * @param wowoOrder 订单对象
     * @return 行数
     */
    Integer addOrder(Order wowoOrder);

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
     * @param sort      排序(正序)
     * @param order     order
     * @return 订单列表
     */
    List<Order> getOrdersByStatusCode(Integer userId, Integer statusCode,
                                          Integer page, Integer limit, String sort, String order);

    /**
     * 根据订单查询信息返回订单对象
     * @param orderId 订单ID：

     * @return 订单
     */
    Order getOrderByOrderId(Integer orderId);

    /**
     * 修改订单
     * @param wowoOrder 订单
     * @return 修改数目
     */
    Integer updateOrderSelective(Order wowoOrder);
}
