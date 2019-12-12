package com.xmu.wowoto.wowomall.dao;

import com.xmu.wowoto.wowomall.domain.OrderItem;
import com.xmu.wowoto.wowomall.domain.po.OrderItemPo;
import com.xmu.wowoto.wowomall.domain.po.OrderPo;
import com.xmu.wowoto.wowomall.domain.po.ProductPo;
import com.xmu.wowoto.wowomall.entity.Product;
import com.xmu.wowoto.wowomall.mapper.OrderItemMapper;
import com.xmu.wowoto.wowomall.mapper.OrderMapper;
import com.xmu.wowoto.wowomall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Repository
public class OrderDao {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private GoodsService goodsService;

    /**
     * 新增订单，包括订单明细
     * @param wowoOrder 订单
     * @return 新订单，带id的
     */
    public OrderPo addOrder(OrderPo wowoOrder){
        orderMapper.addOrder(wowoOrder);
        wowoOrder.setItemsOrderId();
        orderItemMapper.addOrderItems(wowoOrder.getOrderItems());
        return wowoOrder;
    }

    /**
     * 获取用户订单列表
     *
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
     * @param sort      排序
     * @param order     正序或逆序
     * @return 订单列表
     */
    public List<OrderPo> getOrdersByStatusCode(Integer userId, Integer statusCode, Integer page, Integer limit, String sort, String order)
    {
        page = page - 1;
        List<OrderPo> wowoOrders = orderMapper.getOrdersByStatusCode(userId, statusCode, page, limit,sort,order);
        for (OrderPo wowoOrder: wowoOrders) {
            List<OrderItemPo> wowoOrderItems = orderItemMapper.getOrderItemsByOrderId(wowoOrder.getId());
            for (OrderItemPo wowoOrderItem: wowoOrderItems) {
                ProductPo wowoProduct = goodsService.getProductById(wowoOrderItem.getId());
                wowoOrderItem.setPrice(wowoProduct.getPrice());
                wowoOrderItem.setProduct(wowoProduct);
                //?
                wowoOrderItem.setProductId(wowoProduct.getId());
                wowoOrderItem.setGoodsId(wowoProduct.getGoodsId());
                wowoOrderItem.setPicUrl(wowoProduct.getPicUrl());
            }
            wowoOrder.setOrderItems(wowoOrderItems);

        }
        return wowoOrders;
    }

    /**
     * 根据订单查询信息返回订单对象
     * @param orderId 订单ID：
     * @return 订单
     */
    public OrderPo getOrderByOrderId(Integer orderId)
    {
        OrderPo wowoOrder = orderMapper.getOrderByOrderId(orderId);
        List<OrderItemPo> wowoOrderItems = orderItemMapper.getOrderItemsByOrderId(orderId);
        for (OrderItemPo wowoOrderItem: wowoOrderItems){
            ProductPo wowoProduct = goodsService.getProductById(wowoOrderItem.getId());
            wowoOrderItem.setProduct(wowoProduct);
        }
        wowoOrder.setOrderItems(wowoOrderItems);
        return wowoOrder;
    }

    /**
     * 修改订单状态
     * @param wowoOrder 订单
     * @return 修改数量
     */
    public Integer updateOrder(OrderPo wowoOrder){
        return orderMapper.updateOrderSelective(wowoOrder);
    }

    /**
     * 修改订单商品状态
     * @param wowoOrderItem 订单
     * @return 修改数量
     */
    public Integer updateOrderItem(OrderItemPo wowoOrderItem){
        return orderItemMapper.updateOrderItemSelective(wowoOrderItem);
    }



}
