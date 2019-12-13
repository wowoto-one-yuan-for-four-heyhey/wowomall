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
     * @param order 订单对象
     * @return 行数
     */
    Integer addOrder(Order order);

    /**
     * 根据订单查询信息返回订单对象
     * @param userId   用户ID
     * 订单状态
     * -1:全部订单
     * 0：订单生成,未支付
     * 1：下单后未支付，用户取消
     * 2：下单后未支付超时系统自动取消
     * 3：支付完成，商家未发货
     * 4：订单产生，已付款未发货，此时用户取消订单并取得退款（在发货前只要用户点取消订单，无需经过审核）
     * 5:商家发货，用户未确认
     * 6:用户确认收货
     * 7:用户没有确认收货超过一定时间，系统自动确认收货
     * 8:已评价
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
     * @param order 订单
     * @return 修改数目
     */
    Integer updateOrderSelective(Order order);
}
