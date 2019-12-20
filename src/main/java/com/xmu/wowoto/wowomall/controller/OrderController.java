package com.xmu.wowoto.wowomall.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xmu.wowoto.wowomall.controller.vo.SubmitOrderVo;
import com.xmu.wowoto.wowomall.domain.*;
import com.xmu.wowoto.wowomall.domain.Po.GrouponRulePo;
import com.xmu.wowoto.wowomall.service.*;
import com.xmu.wowoto.wowomall.util.ResponseCode;
import com.xmu.wowoto.wowomall.util.ResponseCode.*;
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

import static com.xmu.wowoto.wowomall.util.ResponseCode.*;

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
    private LogService logService;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private RemoteLogService remoteLogService;

    private final static List<Short> emptyArrayList=new ArrayList<>();

    /**
     * 获取用户订单列表
     *
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    @GetMapping("orders")
    @ApiOperation(value = "用户获取订单列表/list", notes = "用户获取订单列表")
    public Object getOrders(@RequestParam(defaultValue = "1")Integer page,
                            @RequestParam(defaultValue = "10")Integer limit,
                            @RequestParam (value="showType",required=false) Integer showType)
    {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(null == userId) {
            return ResponseUtil.unlogin();
        }
        if(showType==null){
            showType=-1;
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
    public Object adminGetOrders(@RequestParam(value="userId",required=false)Integer userId,
                                 @RequestParam(defaultValue = "1")Integer page,
                                 @RequestParam(defaultValue = "10")Integer limit,
                            @RequestParam(defaultValue = "null")String orderSn,
                            @RequestParam(defaultValue="-1") List<Short> orderStatusArray
                            ) {
        Integer adminId = Integer.valueOf(request.getHeader("id"));
        if(null == adminId ) {
            return ResponseUtil.unlogin();
        }
        if((userId!=null&&userId<0)||page<1||limit<0){
            return ResponseUtil.badArgumentValue();
        }
        if(null==userId){
            userId=-1;
        }
        if(orderStatusArray.size()==1 && orderStatusArray.get(0)==-1) {
            orderStatusArray=null;
        }
        List<Order> orders = orderService.getOrdersByStatusCodesAndOrderSn(userId, orderSn, orderStatusArray, page, limit);
        Log log = new Log(request, Log.Type.SELECT.getValue(), "get Orders", 1, 1);
        logService.addLog(log);

        return ResponseUtil.ok(orders);
    }

    /**
     * 管理员获取特定订单详情
     * @param orderId 订单ID
     * @return 订单详细
     */
    @GetMapping("admin/orders/{id}")
    public Object adminOrderDetail(@NotNull @PathVariable("id")Integer orderId)
    {
        Integer adminId = Integer.valueOf(request.getHeader("id"));
        if(null == adminId ) {
            return ResponseUtil.unlogin();
        }
        Order order = orderService.getOrder(orderId);
        if(order == null) { return ResponseUtil.badArgument(); }
        Log log = new Log(request, Log.Type.SELECT.getValue(),
                "get OrdersId"+order.getId(), 1,
                        order.getId());
        logService.addLog(log);
        return ResponseUtil.ok(order);
    }



    /**
     * 获取特定订单详情
     * @param orderId 订单ID
     * @return 订单详细
     */
    @GetMapping("orders/{id}")
    public Object orderDetail(@PathVariable("id")Integer orderId)
    {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(userId == null) { ResponseUtil.unlogin(); }

        Order order = orderService.getOrder(orderId);

        if(order == null) {
            return ResponseUtil.fail(ORDER_INVAILD.getCode(),ORDER_INVAILD.getMessage());
        }
        if(!order.getUserId().equals(userId)) {
            return ResponseUtil.fail(ResponseCode.ORDER_INVAILD_OPERATION.getCode(),
                    ResponseCode.ORDER_INVAILD_OPERATION.getMessage()); }

        if(!order.getUserId().equals(userId)) {
            return ResponseUtil.fail(ORDER_INVAILD_OPERATION.getCode(),ORDER_INVAILD_OPERATION.getMessage());
        }

        return ResponseUtil.ok(order);
    }

    /**
     * 提交订单
     *
     * @param submitOrderVo   订单信息，{ cartId：xxx, addressId: xxx, couponId: xxx, message: xxx, grouponRulesId: xxx,  grouponLinkId: xxx}
     * @return 提交订单操作结果
     */
    @PostMapping("orders")
    public Object submit(@RequestBody SubmitOrderVo submitOrderVo){

        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(null == userId) {   return ResponseUtil.unlogin();}
        if(null == submitOrderVo) { return ResponseUtil.badArgument(); }

        User user = userService.getUserById(userId);
        Address address = submitOrderVo.getAddress();

        Order order = new Order(user, address);

        Integer rebate = submitOrderVo.getRebate();
        if(null != rebate && user.getRebate() >= rebate){
            order.setRebatePrice(BigDecimal.valueOf(submitOrderVo.getRebate() / 100.0));
            userService.updateUserRebate(userId, -rebate);
        }

        if(null != submitOrderVo.getCouponId()){
            order.setCouponId(submitOrderVo.getCouponId());
        }

        List<CartItem> cartItems = new ArrayList<>(submitOrderVo.getCartItemIds().size());
        for(Integer cartItemId: submitOrderVo.getCartItemIds()){
            CartItem cartItem = cartService.findCartItemById(cartItemId);
            if(cartItem == null){
                return ResponseUtil.badArgumentValue();
            }
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
    public Object cancelOrder( @PathVariable("id")Integer orderId) {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(null == userId) {
            return ResponseUtil.unlogin();
        }
        Order order = orderService.getOrder(orderId);
        if(order == null) {
            return ResponseUtil.badArgumentValue();
        }
        if(!order.getUserId().equals(userId)) { return ResponseUtil.unauthz(); }
        if(!order.getStatusCode().equals(Order.StatusCode.NOT_PAYED.getValue())){
            return ResponseUtil.fail(ResponseCode.ORDER_INVAILD_OPERATION.getCode(),
                            ResponseCode.ORDER_INVAILD_OPERATION.getMessage());}
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
    public Object deleteOrder(@PathVariable("id")Integer orderId) {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(null == userId) { return ResponseUtil.unlogin(); }

        Order order = orderService.getOrder(orderId);

        if(order == null) { return ResponseUtil.badArgumentValue(); }
        if(!order.getUserId().equals(userId)) { return
                ResponseUtil.fail(ResponseCode.ORDER_INVAILD_OPERATION.getCode(),
                ResponseCode.ORDER_INVAILD_OPERATION.getMessage());}
        order = orderService.deleteOrder(order);
        return ResponseUtil.ok();
    }

    /**
     * 确认收货
     *
     * @param orderId 订单ID
     * @return 订单操作结果
     */
    @PostMapping("orders/{id}/confirm")
    @ApiOperation(value = "确认收货订单操作结果/confirm")
    public Object confirmOrder( @PathVariable("id")Integer orderId ){
        Integer userId = Integer.valueOf(request.getHeader("id"));
        Order order = orderService.getOrder(orderId);

        if(order == null) { return ResponseUtil.badArgumentValue(); }
        if(!order.getUserId().equals(userId)) {
            return ResponseUtil.fail(ResponseCode.ORDER_INVAILD_OPERATION.getCode(),
                    ResponseCode.ORDER_INVAILD_OPERATION.getMessage());}
        if(!order.getStatusCode().equals(Order.StatusCode.SHIPPED)){
            return ResponseUtil.fail(ResponseCode.ORDER_INVAILD_OPERATION.getCode(),
                ResponseCode.ORDER_INVAILD_OPERATION.getMessage()); }

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
    public Object shipOrder(@PathVariable("id")Integer orderId){
        // orderItem
        Integer adminId = Integer.valueOf(request.getHeader("id"));
        Order order = orderService.getOrder(orderId);

        if(order == null) { return ResponseUtil.badArgumentValue(); }
        if(!order.getUserId().equals(adminId)) { return
                ResponseUtil.fail(ResponseCode.ORDER_INVAILD_OPERATION.getCode(),
                ResponseCode.ORDER_INVAILD_OPERATION.getMessage()); }
        if(!order.getStatusCode().equals(Order.StatusCode.PAYED)){
            return ResponseUtil.fail(ResponseCode.ORDER_INVAILD_OPERATION.getCode(),
                    ResponseCode.ORDER_INVAILD_OPERATION.getMessage());
        }
        order = orderService.shipOrder(order);
        if(order == null){
            return ResponseUtil.illegal();
        }
        Log log=new Log();
        log.setType(2);
        log.setStatusCode(1);
        log.setActionId(order.getId());
        log.setActions("管理员更改订单"+order.toString()+"状态为发货");
        log.setActionId(order.getId());
        remoteLogService.addLog(log);

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
    public Object refundOrder(@ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")Integer orderId,
                              @RequestBody OrderItem orderItem)
    {

        Integer adminId = Integer.valueOf(request.getHeader("id"));
        if(adminId == 0){
            return ResponseUtil.unlogin();
        }
        Order order = orderService.getOrder(orderId);

        if(order == null) {
            return ResponseUtil.badArgumentValue();
        }
        OrderItem item = orderService.getOrderItem(orderItem.getId());
        if(item.getStatusCode().equals(OrderItem.StatusCode.RETURN_SUCCESS.getValue())){
            return ResponseUtil.fail(ResponseCode.ORDER_RETURN_FAILED.getCode(),
                    ResponseCode.ORDER_EXCHANGE_FAILED.getMessage());
        }
        if(item == null){
            return ResponseUtil.badArgumentValue();
        }

        OrderItem reOrderItem = orderService.refundOrderItem(item,order);
        order = orderService.refundOrder(order,reOrderItem);
        if(order == null){
            return ResponseUtil.fail(ResponseCode.ORDER_RETURN_FAILED.getCode(),
                    ResponseCode.ORDER_EXCHANGE_FAILED.getMessage());
        }
        Log log=new Log();
        log.setType(2);
        log.setStatusCode(1);
        log.setActionId(order.getId());
        log.setActions("管理员更改订单"+order.getId()+"状态为退款");

        logService.addLog(log);
        return ResponseUtil.ok(order);
    }

    /**
     * 提供接口给payment回调，修改订单为付款或者退款
     * @param id 订单ID
     * @return 是否成功发起支付
     */
    @PutMapping("orders/{id}/paymentStatus")
    public Object orderPayed(@PathVariable("id")Integer id )
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

            return ResponseUtil.ok(1);
        }
        else{
            return ResponseUtil.fail(ResponseCode.ORDER_PAIMENT_FAILED.getCode(),
                    ResponseCode.ORDER_PAIMENT_FAILED.getMessage());
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
        Integer number = orderService.getGrouponOrdersNum(goodsId,startTime,
                endTime);
        return ResponseUtil.ok(number);
    }

    /**
     * 用户点击支付   //包含预售尾款定金判断
     * @param id
     * @return
     */
    @PostMapping("orders/{id}/payment")
    public Object payOrder(@PathVariable Integer id){
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(userId == null){
            return ResponseUtil.unlogin();
        }
        List<Payment> list = paymentService.getPaymentById(id);
        if(list == null){
            return ResponseUtil.badArgumentValue();
        }
        if(list.size() == 1){
           paymentService.payPayment(list.get(0).getId());
        }
        else{
           if(list.get(0).getBeginTime().isBefore(list.get(1).getBeginTime())) {
               if(!list.get(0).getBeSuccessful()){
                   paymentService.payPayment(list.get(0).getId());
               }
           }
           else{
               if(!list.get(1).getBeSuccessful()){
                   if(LocalDateTime.now().isAfter(list.get(1).getBeginTime()) &&
                       LocalDateTime.now().isAfter(list.get(1).getEndTime())) {
                       paymentService.payPayment(list.get(1).getId());
                   }
               }
           }
        }
        return ResponseUtil.ok();
    }

    /**
     * 提供给discount模块用于团购成功还款
     * @param grouponRulePo
     * @param rate
     * @return
     */
    @PostMapping("orders/grouponOrders/refund")
    public Object grouponRefund(@RequestBody GrouponRulePo grouponRulePo, @RequestParam Double rate) {
        Integer goodsId = grouponRulePo.getId();
        if (null == goodsId) { return ResponseUtil.badArgumentValue(); }
        List<Payment> payments = orderService.refundGrouponOrders(grouponRulePo.getGoodsId(),
                grouponRulePo.getStartTime(), grouponRulePo.getEndTime(), rate);
        if(payments.size() > 0){
                return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(ResponseCode.ORDER_RETURN_FAILED.getCode(),
                    ResponseCode.ORDER_RETURN_FAILED.getMessage());
        }
    }

    /**
     * 预售取消退款
     * @param presaleRule
     * @return
     */
    @PostMapping("orders/presaleRule/refund")
    public Object presaleRefund(@RequestBody PresaleRule presaleRule){
        Integer goodsId = presaleRule.getGoodsId();
        if(null == goodsId){ return ResponseUtil.badArgument(); }
        List<Payment> payments = orderService.refundPresaleOrders(presaleRule.getGoodsId(),
                presaleRule.getStartTime(), presaleRule.getEndTime());
        if(payments.size() > 0) {
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail(ResponseCode.ORDER_RETURN_FAILED.getCode(),
                    ResponseCode.ORDER_RETURN_FAILED.getMessage());
        }
    }
}
