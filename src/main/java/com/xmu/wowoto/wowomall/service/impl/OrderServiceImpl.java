package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.dao.OrderDao;
import com.xmu.wowoto.wowomall.domain.WowoCartItem;
import com.xmu.wowoto.wowomall.domain.WowoOrder;
import com.xmu.wowoto.wowomall.domain.WowoOrderItem;
import com.xmu.wowoto.wowomall.service.CartItemService;
import com.xmu.wowoto.wowomall.service.GoodsService;
import com.xmu.wowoto.wowomall.service.OrderService;
import com.xmu.wowoto.wowomall.util.ResponseUtil;
import com.xmu.wowoto.wowomall.util.WxResponseCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.xmu.wowoto.wowomall.util.WxResponseCode.ORDER_INVALID;
import static com.xmu.wowoto.wowomall.util.WxResponseCode.ORDER_UNKNOWN;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CartItemService cartItemService;

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
                wowoOrderItemVoList.add(wowoOrderItemVo);
            }
            wowoOrderVo.put("orderItemList",wowoOrderItemVoList);
            wowoOrderVoList.add(wowoOrderVo);
        }
        return ResponseUtil.ok(wowoOrderVoList);
    }

    @Override
    public WowoOrder submit(WowoOrder wowoOrder, List<WowoCartItem> wowoCartItems) {
        if(this.createOrderItemFromCartItem(wowoOrder, wowoCartItems)){
            cartItemService.clearCartItem(wowoCartItems);
            wowoOrder.cacuDealPrice();
        }
        return wowoOrder;
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
                wowoCartItems.add(wowoCartItem);
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
            return ResponseUtil.fail(ORDER_UNKNOWN ,"订单不存在");
        }
        if(oneOrder.getUserId() != userId)
        {
            return ResponseUtil.fail(ORDER_INVALID ,"该订单不属于当前用户");
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
        if(oneOrder == null){ return  ResponseUtil.fail(ORDER_UNKNOWN,"数据库中不存在该资源"); }
        if(WowoOrder.STATUSCODE.REFUND.getValue() >= oneOrder.getStatusCode()){
            oneOrder.setStatusCode(WowoOrder.STATUSCODE.REFUND.getValue());
            List<WowoOrderItem> orderItems= oneOrder.getWowoOrderItems();
            for(WowoOrderItem item : orderItems){
                Integer itemId = item.getOrderId();
                // 对item的操作
            }

            Integer status = orderDao.updateOrderByOrderId(oneOrder);
            if(status == 1) {
                //对用户 钱进行更新
                // 对价格进行更新

                //return ResponseUtil.ok(updateNum);
                return ResponseUtil.ok();
            }
            else{
                return ResponseUtil.fail(ORDER_INVALID,"数据库更新失败");
            }
        }
       return  ResponseUtil.fail();
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
        /*syb*/
        return true;
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
        /*syb*/
        return true;
    }

    @Override
    public Object shipOrder(Integer userId,Integer orderId){
        WowoOrder oneOrder = orderDao.getOrderByOrderId(orderId);
        if(oneOrder == null){ return  ResponseUtil.fail(ORDER_UNKNOWN,"数据库中不存在该资源"); }
        if(WowoOrder.STATUSCODE.NOT_TAKEN.getValue() >= oneOrder.getStatusCode()) {
            oneOrder.setStatusCode(WowoOrder.STATUSCODE.NOT_TAKEN.getValue());
            Integer updateNum = orderDao.updateOrderByOrderId(oneOrder);
            if(updateNum == 1){
                return ResponseUtil.ok(updateNum);
            }else {
                return ResponseUtil.fail(ORDER_INVALID,"数据库更新失败");
            }
        } else {  return ResponseUtil.fail(ORDER_INVALID,"订单状态更新不合法");
    }
    }

}
