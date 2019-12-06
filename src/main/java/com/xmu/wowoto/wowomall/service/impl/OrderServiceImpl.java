package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.dao.OrderDao;
import com.xmu.wowoto.wowomall.domain.WowoCartItem;
import com.xmu.wowoto.wowomall.domain.WowoOrder;
import com.xmu.wowoto.wowomall.domain.WowoOrderItem;
import com.xmu.wowoto.wowomall.service.OrderService;
import com.xmu.wowoto.wowomall.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
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
     * @return 订单列表
     */
    public Object getOrders(Integer userId, Integer statusCode, Integer page, Integer limit,String sort,String order)
    {
       //if(userId==null)  return;
        List<WowoOrder> wowoOrderList=orderDao.getOrdersByStatusCode(userId, statusCode, page, limit,sort,order);
        List<Map<String, Object>> wowoOrderVoList=new ArrayList<>(wowoOrderList .size());
        for(WowoOrder oneOrder:wowoOrderList)
        {
            Map<String, Object> wowoOrderVo=new HashMap<>();
            wowoOrderVo.put("id",oneOrder.getId());
            wowoOrderVo.put("orderSn",oneOrder.getOrderSn());
            wowoOrderVo.put("goodsPrice",oneOrder.getGoodsPrice());
            List<WowoOrderItem> wowoOrderItemList = orderDao.getOrderItemsByOrderId(oneOrder.getId());
       //     System.out.println(wowoOrderItemList);
            List wowoOrderItemVoList=new ArrayList<>(wowoOrderItemList .size());
            for(WowoOrderItem oneItem:wowoOrderItemList)
            {
                Map<String, Object> wowoOrderItemVo=new HashMap<>();
                wowoOrderItemVo.put("id",oneItem.getId());
                wowoOrderItemVo.put("dealPrice",oneItem.getDealPrice());
                wowoOrderItemVo.put("productId",oneItem.getProductId());
                wowoOrderItemVoList.add(wowoOrderItemVo);
            }
            wowoOrderVo.put("orderItemList",wowoOrderItemVoList);
            wowoOrderVoList.add(wowoOrderVo);
        }
        return ResponseUtil.ok(wowoOrderVoList);
    }

    @Override
    public WowoOrder submit(WowoOrder wowoOrder, List<WowoCartItem> wowoCartItems) {
        List<WowoOrderItem> wowoOrderItems = new ArrayList<>();
        for (WowoCartItem wowoCartItem: wowoCartItems){

        }
        return null;
    }

    /**
     * 获取用户特定订单详情
     *
     * @param orderId 订单ID
     * @return 订单列表
     */
    public Object getOrderDetail(Integer orderId)
    {
        WowoOrder oneOrder=orderDao.getOrderByOrderId(orderId);
        List<WowoOrderItem> wowoOrderItemList = orderDao.getOrderItemsByOrderId(oneOrder.getId());
        oneOrder.setWowoOrderItems(wowoOrderItemList);
        Map<String, Object> orderVo = new HashMap<String, Object>();
        orderVo.put("id", oneOrder.getId());
        orderVo.put("statusCode", oneOrder.getStatusCode());
        orderVo.put("orderSn", oneOrder.getOrderSn());
        orderVo.put("message", oneOrder.getMessage());
        orderVo.put("consignee", oneOrder.getConsignee());
        orderVo.put("mobile", oneOrder.getMobile());
        orderVo.put("address", oneOrder.getAddress());
        orderVo.put("goodsPrice", oneOrder.getGoodsPrice());
        orderVo.put("couponPrice", oneOrder.getCouponPrice());
        orderVo.put("freightPrice", oneOrder.getFreightPrice());
        orderVo.put("integralPrice", oneOrder.getIntegralPrice());
        orderVo.put("shipSn", oneOrder.getShipSn());
        orderVo.put("shipChannel", oneOrder.getShipChannel());
        orderVo.put("shipTime", oneOrder.getShipTime());
        orderVo.put("payTime", oneOrder.getPayTime());
        orderVo.put("orderItemList",wowoOrderItemList);
        System.out.println(orderVo);
        return ResponseUtil.ok(orderVo);
    }
}
