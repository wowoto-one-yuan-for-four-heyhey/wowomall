package com.xmu.wowoto.wowomall.controller;

import com.xmu.wowoto.wowomall.controller.vo.SubmitOrderVo;
import com.xmu.wowoto.wowomall.domain.*;
import com.xmu.wowoto.wowomall.domain.Po.GrouponRulePo;
import com.xmu.wowoto.wowomall.service.CartService;
import com.xmu.wowoto.wowomall.service.DiscountService;
import com.xmu.wowoto.wowomall.service.OrderService;
import com.xmu.wowoto.wowomall.service.UserService;
import com.xmu.wowoto.wowomall.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Api(value="Order",tags = "订单")
@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 获取用户订单列表
     *
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    @GetMapping("orders")
    @ApiOperation(value = "用户获取订单列表/list", notes = "用户获取订单列表")
    public Object getOrders(@RequestParam(defaultValue = "-1")Integer showType,
                            @RequestParam(defaultValue = "1")Integer page,
                            @RequestParam(defaultValue = "10")Integer limit)
    {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(null == userId) {
            return ResponseUtil.unlogin();
        }
        List<Order> orders = orderService.getOrders(userId, showType, page, limit);
        return ResponseUtil.ok(orders);
    }


    /**
     * 获取用户订单列表
     *
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    @GetMapping("admin/orders")
    @ApiOperation(value = "管理员获取订单列表/list", notes = "管理员获取订单列表")
    public Object getOrders(@RequestParam(defaultValue = "-1")Integer userId,
                            @RequestParam(defaultValue = "-1")Integer showType,
                            @RequestParam(defaultValue = "1")Integer page,
                            @RequestParam(defaultValue = "10")Integer limit) {
        Integer adminId = Integer.valueOf(request.getHeader("id"));
        if(null == adminId) {
            return ResponseUtil.unlogin();
        }
        List<Order> orders = orderService.getOrders(userId,showType,page,limit);
        return ResponseUtil.ok(orders);
    }



    /**
     * 获取特定订单详情
     * @param orderId 订单ID
     * @return 订单详细
     */
    @GetMapping("orders/{id}")
    public Object orderDetail(@NotNull @PathVariable("id")Integer orderId)
    {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(userId == null) { ResponseUtil.unlogin(); }

        Order order = orderService.getOrder(orderId);

        if(order == null) { return ResponseUtil.badArgument(); }
        if(!order.getUserId().equals(userId)) { return ResponseUtil.unauthz(); }

        return ResponseUtil.ok(order);
    }

    /**
     * 提交订单
     *
     * @param submitOrderVo   订单信息，{ cartId：xxx, addressId: xxx, couponId: xxx, message: xxx, grouponRulesId: xxx,  grouponLinkId: xxx}
     * @return 提交订单操作结果
     */
    @PostMapping("orders")
    public Object submit( @RequestBody SubmitOrderVo submitOrderVo){

        Integer userId = Integer.valueOf(request.getHeader("userId"));
        if(null == userId) {   return ResponseUtil.unlogin();}
        if(null == submitOrderVo) { return ResponseUtil.badArgument(); }

        User user = userService.getUserById(userId);
        Address address = submitOrderVo.getAddress();

        Order order = new Order(user, address);

        Integer rebate = submitOrderVo.getRebate();
        if(null != rebate && user.getRebate() >= rebate){
            order.setRebatePrice(BigDecimal.valueOf(submitOrderVo.getRebate() / 100.0));
            userService.addRebate(userId, rebate);
        }

        if(null != submitOrderVo.getCouponId()){ order.setCouponId(submitOrderVo.getCouponId()); }

        List<CartItem> cartItems = new ArrayList<>(submitOrderVo.getCartItemIds().size());
        for(Integer cartItemId: submitOrderVo.getCartItemIds()){
            CartItem cartItem = cartService.findCartItemById(cartItemId);
            cartItems.add(cartItem);
        }

        order = orderService.submit(order, cartItems);

        return ResponseUtil.ok(order);
    }

    /**
     * 取消订单
     *
     * @param orderId   订单ID
     * @return 取消订单操作结果
     */
    @PutMapping("orders/{id}/cancel")
    @ApiOperation(value = "取消订单操作结果/cancel", notes = "取消订单操作结果")
    public Object cancelOrder( @PathVariable("id")String orderId) {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(null == userId) { return ResponseUtil.unlogin(); }
        Order order = orderService.getOrder(Integer.parseInt(orderId));

        if(order == null) { return ResponseUtil.badArgumentValue(); }
        if(!order.getUserId().equals(userId)) { return ResponseUtil.unauthz(); }

        order = orderService.cancelOrder(order);
        return ResponseUtil.ok(order);
    }

    /**
     * 删除订单
     *
     * @param orderId   订单ID
     * @return 删除订单操作结果
     */
    @DeleteMapping("orders/{id}")
    @ApiOperation(value = "取消订单操作结果/cancel", notes = "取消订单操作结果")
    public Object deleteOrder(@PathVariable("id")String orderId) {
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        if(null == userId) { return ResponseUtil.unlogin(); }

        Order order = orderService.getOrder(Integer.parseInt(orderId));

        if(order == null) { return ResponseUtil.badArgumentValue(); }
        if(!order.getUserId().equals(userId)) { return ResponseUtil.unauthz(); }

        order = orderService.deleteOrder(order);

        return ResponseUtil.ok(order);
    }

    /**
     * 确认收货
     *
     * @param orderId 订单ID
     * @return 订单操作结果
     */
    @PostMapping("orders/{id}/confirm")
    @ApiOperation(value = "确认收货订单操作结果/confirm")
    public Object confirmOrder( @PathVariable("id")String orderId ){
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Order order = orderService.getOrder(Integer.parseInt(orderId));

        if(order == null) { return ResponseUtil.badArgumentValue(); }
        if(!order.getUserId().equals(userId)) { return ResponseUtil.unauthz(); }

        if(!order.getStatusCode().equals(Order.StatusCode.SHIPPED)){ return ResponseUtil.illegal(); }

        order = orderService.confirm(order);

        return ResponseUtil.ok(order);
    }

    /**
     * 更改订单状态为发货(管理员操作)
     *
     * @param orderId   订单ID
     * @return 更改列表
     */
    @PostMapping("orders/{id}/ship")
    @ApiOperation("更改订单状态为发货(管理员操作)")
    public Object shipOrder(@PathVariable("id")String orderId){
        // orderItem
        Integer adminId = Integer.valueOf(request.getHeader("id"));
        Order order = orderService.getOrder(Integer.parseInt(orderId));

        if(order == null) { return ResponseUtil.badArgumentValue(); }
        if(!order.getUserId().equals(adminId)) { return ResponseUtil.unauthz(); }

        order = orderService.shipOrder(order);
        if(order == null){
            return ResponseUtil.illegal();
        }
        return ResponseUtil.ok(order);
    }

    /**
     * 更改订单状态为退款(管理员操作)
     *
     * @param orderId   订单ID
     * @return 更改列表

     */
    @PostMapping("orders/{id}/refund")
    @ApiOperation("更改订单状态为退款(管理员操作)")
    public Object refundOrder(@ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")String orderId){
        Integer adminId = Integer.valueOf(request.getHeader("id"));
        Order order = orderService.getOrder(Integer.parseInt(orderId));


        if(order == null) { return ResponseUtil.badArgumentValue(); }

        order = orderService.refundOrder(order);
        return ResponseUtil.ok(order);
    }

    /**
     * 提供接口给payment回调，修改该订单为付款完成
     * @param id 订单ID
     * @return 是否成功发起支付
     */
    @PutMapping("orders/{id}")
    public Object payOrder(@PathVariable("id")Integer id)
    {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(userId == null){ return ResponseUtil.unlogin(); }
        Order order = orderService.getOrder(id);
        if(order == null){ return ResponseUtil.badArgumentValue(); }

        HashMap<String,Integer> result=orderService.payOrder(order);
        if(result.containsKey("orderItem")){
            return ResponseUtil.fail();
        }
        Integer payStatus=result.get("order");
        if(payStatus > -1){
            return ResponseUtil.ok(result);
        }
        else{
            return ResponseUtil.fail();
        }
    }

    /**
     * 提供接口给AfterSale查看orderItem是什么类型
     * @param orderItemId
     * @return
     */
    @GetMapping("orderItem/{orderItemId}/goodsType")
    public Object findOrderItemType(@PathVariable("orderItemId") Integer orderItemId ){
        OrderItem orderItem = orderService.getOrderItem(orderItemId);
        if(orderItem == null){ return ResponseUtil.badArgumentValue(); }
        Integer goodsType = orderItem.getItemType();
        return ResponseUtil.ok(goodsType);
    }

    /**
     * 查询grouponrule的参团人数 discountService调用
     * @param grouponRulePo
     * @return
     */
    @GetMapping("orders/grouponOrders")
    public Object getGrouponOrders(@RequestBody GrouponRulePo grouponRulePo){
        Integer goodsId = grouponRulePo.getGoodsId();
        LocalDateTime startTime = grouponRulePo.getStartTime();
        LocalDateTime endTime = grouponRulePo.getEndTime();
        List<Order> orders = orderService.getGrouponOrders(goodsId,startTime,endTime);
        return ResponseUtil.ok(orders);
    }
}
