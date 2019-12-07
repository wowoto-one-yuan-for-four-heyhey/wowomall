package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.dao.OrderDao;
import com.xmu.wowoto.wowomall.domain.WowoCartItem;
import com.xmu.wowoto.wowomall.domain.WowoOrder;
import com.xmu.wowoto.wowomall.domain.WowoOrderItem;
import com.xmu.wowoto.wowomall.service.CartService;
import com.xmu.wowoto.wowomall.service.GoodsService;
import com.xmu.wowoto.wowomall.service.OrderService;
import com.xmu.wowoto.wowomall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.xmu.wowoto.wowomall.util.ResponseCode.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderDao orderDao;
    /**
     * 获取用户订单列表
     *
     * @param userId   用户ID
     * @param statusCode 订单信息：
     *                 1未付款，
     *                 2未发货，
     *                 3未收货，
     *                 4未评价，
     *                 5已完成订单，
     *                 6退货订单，
     *                 7换货订单
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    @Override
    public Object getOrders(Integer userId, Integer statusCode, Integer page, Integer limit,String sort,String order)
    {
        if(userId==null)
        {
            return ResponseUtil.unlogin();
        }
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
                wowoOrderItemVo.put("nameWithSpecifications",oneItem.getNameWithSpecifications());
                wowoOrderItemVo.put("picUrl",oneItem.getPicUrl());
                wowoOrderItemVoList.add(wowoOrderItemVo);
            }
            wowoOrderVo.put("orderItemList",wowoOrderItemVoList);
            wowoOrderVoList.add(wowoOrderVo);
        }
        return ResponseUtil.ok(wowoOrderVoList);
    }

    @Override
    public WowoOrder submit(WowoOrder wowoOrder, List<WowoCartItem> wowoCartItems) {
        WowoOrder newOrder = null;
        if(this.createOrderItemFromCartItem(wowoOrder, wowoCartItems)){
            cartService.clearCartItem(wowoCartItems);
            wowoOrder.cacuDealPrice();

            newOrder = orderDao.addOrder(wowoOrder);
        }


        return newOrder;
    }

    /**
     * 用CartItem构造OrderItem
     * @param wowoOrder 订单对象
     * @param wowoCartItems 购物车对象列表
     */
    private Boolean createOrderItemFromCartItem(WowoOrder wowoOrder, List<WowoCartItem> wowoCartItems) {
        List<WowoOrderItem> wowoOrderItems = new ArrayList<>(wowoCartItems.size());
        for (WowoCartItem wowoCartItem: wowoCartItems){
            if(goodsService.deductStock(wowoCartItem.getProductId(), wowoCartItem.getNumber())){
                WowoOrderItem wowoOrderItem = new WowoOrderItem((wowoCartItem));
                wowoOrderItems.add(wowoOrderItem);
            }else {
                return false;
            }
        }
        wowoOrder.setWowoOrderItems(wowoOrderItems);
        return true;
    }

    /**
     * 获取用户特定订单详情
     *
     * @param orderId 订单ID
     * @return 订单列表
     */
    @Override
    public Object getOrderDetail(Integer userId,Integer orderId)
    {
        if(userId==null)
        {
            return ResponseUtil.unlogin();
        }
        WowoOrder oneOrder=orderDao.getOrderByOrderId(orderId);
        if(oneOrder==null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(oneOrder.getUserId() != userId)
        {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
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

    /**
     * 更改订单状态为退款(管理员操作)
     *
     * @param orderId 订单ID
     * @param userId 用户ID
     * @return 订单列表
     */
    @Override
    public Object refundOrder(Integer userId,Integer orderId){
        /*xbb*/
        WowoOrder oneOrder = orderDao.getOrderByOrderId(orderId);
        if(oneOrder == null){ return  ResponseUtil.fail(ORDER_INVALID.getCode(),ORDER_INVALID.getMessage()); }
        if(WowoOrder.STATUSCODE.REFUND.getValue() >= oneOrder.getStatusCode()){
            oneOrder.setStatusCode(WowoOrder.STATUSCODE.REFUND.getValue());
            List<WowoOrderItem> orderItems= oneOrder.getWowoOrderItems();
            for(WowoOrderItem item : orderItems){
                Integer itemId = item.getOrderId();
                // 对item的操作
            }

            Integer status = orderDao.updateOrder(oneOrder);
            if(status == 1) {
                //对用户 钱进行更新
                // 对价格进行更新

                //return ResponseUtil.ok(updateNum);
                return ResponseUtil.ok();
            }
            else{
                return ResponseUtil.fail(ORDER_INVALID.getCode(),ORDER_INVALID.getMessage());
            }
        }
       return  ResponseUtil.fail();
    }

    /**
     * 提供给支付模块修改订单状态->支付成功  (供paymentService调用)"
     * @param userId 用户ID
     * @param orderId 订单ID
     * statusCode PAYED
     * @return 是否成功
     */
    public Object payOrder(Integer userId, Integer orderId) {
        if (userId == null) {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode(), ORDER_INVALID_OPERATION.getMessage());
        }
        WowoOrder oneOrder = orderDao.getOrderByOrderId(orderId);
        if (oneOrder == null) {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode(), ORDER_UNKNOWN.getMessage());
        }
        if (oneOrder.getUserId().equals(userId)) {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode(), ORDER_INVALID_OPERATION.getMessage());
        }
        if (WowoOrder.STATUSCODE.PAYED.getValue() >= oneOrder.getStatusCode()) {
            List<WowoOrderItem> orderItems = oneOrder.getWowoOrderItems();
            for (WowoOrderItem item : orderItems) {
                Integer itemId = item.getOrderId();
                /**对item的操作 orderItem是否一并更新尚不明确*/
            }
            Integer status = orderDao.updateOrder(oneOrder);
            if (status == 1) {
                /**更新成功*/
                return ResponseUtil.ok();
            } else {
                return ResponseUtil.fail(ORDER_INVALID.getCode(), ORDER_INVALID.getMessage());
            }

        }
        return true;
    }


            /**
             * 取消订单
             *
             * @param userId   用户ID
             * @param orderId  订单ID
             * @return 操作结果
             */
    @Override
    public Object cancelOrder(Integer userId, Integer orderId){
        return false;
    }

    /**
     * 删除订单
     *
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 操作结果
     */
    @Override
    public Object deleteOrder(Integer userId, Integer orderId){
        WowoOrder wowoOrder = orderDao.getOrderByOrderId(orderId);
        if(null != wowoOrder){
            wowoOrder.setStatusCode(WowoOrder.STATUSCODE.FINISHED.getValue());
            for(WowoOrderItem wowoOrderItem: wowoOrder.getWowoOrderItems()){
                wowoOrderItem.setBeDeleted(true);
                if(orderDao.updateOrderItem(wowoOrderItem) < 1){
                    return ResponseUtil.fail(ORDER_INVALID.getCode(),ORDER_INVALID.getMessage());
                }
            }
            wowoOrder.setBeDeleted(true);
            return ResponseUtil.ok(orderDao.updateOrder(wowoOrder));
        }else {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode(),ORDER_UNKNOWN.getMessage());
        }
    }

    /**
     * 订单发货
     *
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 操作结果
     */
    @Override
    public Object shipOrder(Integer userId,Integer orderId){
        WowoOrder oneOrder = orderDao.getOrderByOrderId(orderId);
        if(oneOrder == null){
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode(),ORDER_UNKNOWN.getMessage());
        }
        if(WowoOrder.STATUSCODE.NOT_TAKEN.getValue() >= oneOrder.getStatusCode()) {
            oneOrder.setStatusCode(WowoOrder.STATUSCODE.NOT_TAKEN.getValue());
            Integer updateNum = orderDao.updateOrder(oneOrder);
            if(updateNum == 1){
                return ResponseUtil.ok(updateNum);
            }else {
                return ResponseUtil.fail(ORDER_INVALID.getCode(),ORDER_INVALID.getMessage());
            }
        } else {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode(),ORDER_INVALID_OPERATION.getMessage());
        }
    }

    /**
     * 订单确认
     *
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 操作结果
     */
    @Override
    public Object confirm(Integer userId,Integer orderId){
        WowoOrder oneOrder = orderDao.getOrderByOrderId(orderId);
        if(oneOrder == null){
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode(),ORDER_UNKNOWN.getMessage());
        }
        if(oneOrder.getStatusCode() == WowoOrder.STATUSCODE.NOT_TAKEN.getValue()) {
            oneOrder.setStatusCode(WowoOrder.STATUSCODE.NOT_COMMENTED.getValue());
            Integer updateNum = orderDao.updateOrder(oneOrder);
            if(updateNum == 1){
                return ResponseUtil.ok(updateNum);
            }else {
                return ResponseUtil.fail(ORDER_INVALID.getCode(),ORDER_INVALID.getMessage());
            }
        } else {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode(),ORDER_INVALID_OPERATION.getMessage());
        }
    }




}


