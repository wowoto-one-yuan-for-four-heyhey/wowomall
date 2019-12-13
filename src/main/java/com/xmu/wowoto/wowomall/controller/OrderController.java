package com.xmu.wowoto.wowomall.controller;

import com.xmu.wowoto.wowomall.controller.vo.GetOrdersVo;
import com.xmu.wowoto.wowomall.controller.vo.OrderItemVo;
import com.xmu.wowoto.wowomall.controller.vo.ProductVo;
import com.xmu.wowoto.wowomall.controller.vo.SubmitOrderVo;
import com.xmu.wowoto.wowomall.domain.*;
import com.xmu.wowoto.wowomall.service.CartService;
import com.xmu.wowoto.wowomall.service.CouponService;
import com.xmu.wowoto.wowomall.service.OrderService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.xmu.wowoto.wowomall.util.ResponseCode.ORDER_INVALID_OPERATION;
import static com.xmu.wowoto.wowomall.util.ResponseCode.ORDER_UNKNOWN;


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
    private OrderService orderService;


    @Autowired
    private CartService cartService;

    @Autowired
    private CouponService couponService;

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
                            @RequestParam(defaultValue = "10")Integer limit,
                            @RequestParam(defaultValue = "add_time") String sort,
                            @RequestParam(defaultValue = "desc") String orderWay)
    {
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        if(null == userId) {
            return ResponseUtil.unlogin();
        }
        List<Order> orders = orderService.getOrders(userId,showType,page,limit,sort,orderWay);
        List<GetOrdersVo> getOrdersVos = new ArrayList<>(orders.size());
        for (int i = 0; i < orders.size(); i++){
            GetOrdersVo getOrdersVo = getOrdersVos.get(i);
            Order order = orders.get(i);
            getOrdersVo.setOrder(order);
            getOrdersVo.setAddress(order.getAddress());
            List<OrderItemVo> orderItemVos = new ArrayList<>(order.getOrderItemList().size());
            for (int j = 0; j < orderItemVos.size(); j++){
                OrderItem orderItem = order.getOrderItemList().get(j);
                OrderItemVo orderItemVo = orderItemVos.get(j);
                orderItemVo.setOrderItem(orderItem);
                ProductVo productVo = new ProductVo();
                productVo.setProduct(orderItem.getProduct());
                orderItemVo.setProductVo(productVo);
            }
            getOrdersVo.setOrderItemVo(orderItemVos);
        }
        return ResponseUtil.ok(getOrdersVos);
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
    public Object getOrders(@RequestParam(defaultValue = "-1")Integer showType,
                            @RequestParam(defaultValue = "1")Integer page,
                            @RequestParam(defaultValue = "10")Integer limit,
                            @RequestParam(defaultValue = "add_time") String sort,
                            @RequestParam(defaultValue = "desc") String orderWay)
    {
        Integer adminId = Integer.valueOf(request.getHeader("adminId"));
        if(null == adminId) {
            return ResponseUtil.unlogin();
        }
        List<Order> orders = orderService.getOrders(adminId,showType,page,limit,sort,orderWay);
        List<GetOrdersVo> getOrdersVos = new ArrayList<>(orders.size());
        for (int i = 0; i < orders.size(); i++){
            GetOrdersVo getOrdersVo = getOrdersVos.get(i);
            Order order = orders.get(i);
            getOrdersVo.setOrder(order);
            getOrdersVo.setAddress(order.getAddress());
            List<OrderItemVo> orderItemVos = new ArrayList<>(order.getOrderItemList().size());
            for (int j = 0; j < orderItemVos.size(); j++){
                OrderItem orderItem = order.getOrderItemList().get(j);
                OrderItemVo orderItemVo = orderItemVos.get(j);
                orderItemVo.setOrderItem(orderItem);
                ProductVo productVo = new ProductVo();
                productVo.setProduct(orderItem.getProduct());
                orderItemVo.setProductVo(productVo);
            }
            getOrdersVo.setOrderItemVo(orderItemVos);
        }
        return ResponseUtil.ok(getOrdersVos);
    }



    /**
     * 获取用户特定订单详情
     * @param orderId 订单ID
     * @return 订单详细
     */
    @GetMapping("orders/{id}")
    @ApiOperation("查看特定订单的订单详情(用户)")
    public Object userDetail(@NotNull @PathVariable("id")Integer orderId)
    {
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        if(userId == null) {
            ResponseUtil.unlogin();
        }
        Order order = orderService.getOrder(orderId);

        if(order == null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!order.getUserId().equals(userId))
        {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }


        GetOrdersVo getOrdersVo = new GetOrdersVo();
        getOrdersVo.setOrder(order);
        getOrdersVo.setAddress(order.getAddress());
        List<OrderItemVo> orderItemVos = new ArrayList<>(order.getOrderItemList().size());
        for (int i = 0; i < orderItemVos.size(); i++){
            OrderItemVo orderItemVo = orderItemVos.get(i);
            OrderItem orderItem = order.getOrderItemList().get(i);
            orderItemVo.setOrderItem(orderItem);
            ProductVo productVo = new ProductVo();
            productVo.setProduct(orderItem.getProduct());
            orderItemVo.setProductVo(productVo);
        }
        getOrdersVo.setOrderItemVo(orderItemVos);
        return ResponseUtil.ok(getOrdersVo);
    }


    /**
     * 获取管理员特定订单详情
     * @param orderId 订单ID
     * @return 订单详细
     */
    @GetMapping("admin/orders/{id}")
    @ApiOperation("查看特定订单的订单详情(管理员)")
    public Object userDetail(@NotNull @PathVariable("id")Integer orderId)
    {
        Integer adminId = Integer.valueOf(request.getHeader("adminId"));
        if(adminId == null) {
            ResponseUtil.unlogin();
        }
        Order order = orderService.getOrder(orderId);

        if(order == null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }

        GetOrdersVo getOrdersVo = new GetOrdersVo();
        getOrdersVo.setOrder(order);
        getOrdersVo.setAddress(order.getAddress());
        List<OrderItemVo> orderItemVos = new ArrayList<>(order.getOrderItemList().size());
        for (int i = 0; i < orderItemVos.size(); i++){
            OrderItemVo orderItemVo = orderItemVos.get(i);
            OrderItem orderItem = order.getOrderItemList().get(i);
            orderItemVo.setOrderItem(orderItem);
            ProductVo productVo = new ProductVo();
            productVo.setProduct(orderItem.getProduct());
            orderItemVo.setProductVo(productVo);
        }
        getOrdersVo.setOrderItemVo(orderItemVos);
        return ResponseUtil.ok(getOrdersVo);
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
        logger.debug("submit: " + submitOrderVo);
        if(null == userId)
        {   return ResponseUtil.unlogin();}
        if(null == submitOrderVo) {
            return ResponseUtil.badArgument();
        }
        Order order = new Order();
        order.setAddress(submitOrderVo.getAddress());

        if(null != submitOrderVo.getCouponId()){
            Coupon coupon = couponService.findCouponById(submitOrderVo.getCouponId());
            order.setCouponId(coupon.getId());
        }

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
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        if(null == userId) {
            return ResponseUtil.unlogin();
        }
        Order order = orderService.getOrder(Integer.parseInt(orderId));

        if(order == null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!order.getUserId().equals(userId))
        {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        orderService.cancelOrder(userId, Integer.parseInt(orderId));
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
        if(null == userId) {
            return ResponseUtil.unlogin();
        }
        Order order = orderService.getOrder(Integer.parseInt(orderId));

        if(order == null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!order.getUserId().equals(userId))
        {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        orderService.deleteOrder(userId, Integer.parseInt(orderId));
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
    public Object confirm(
            @ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")String orderId){
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Order order = orderService.getOrder(Integer.parseInt(orderId));

        if(order == null) {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!order.getUserId().equals(userId)) {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        orderService.confirm(userId, Integer.parseInt(orderId));
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
    public Object shipOrder(@ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")String orderId){
        // orderItem
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Order order = orderService.getOrder(Integer.parseInt(orderId));

        if(order == null) {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!order.getUserId().equals(userId)) {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        orderService.shipOrder(userId,Integer.parseInt(orderId));
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
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        Order order = orderService.getOrder(Integer.parseInt(orderId));

        if(order == null) {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!order.getUserId().equals(userId)) {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        orderService.refundOrder(userId,Integer.parseInt(orderId));
        return ResponseUtil.ok(order);
    }


    /**
     * 待评价订单商品信息/goods (用户操作)
     * @param limit 每页条数
     * @param page 页码
     * @param sort 以什么为序
     * @param order 升/降序
     * @return 订单详细
     */
    @GetMapping("orders/unevaluated")
    @ApiOperation("查看未评价订单的订单详情")
    public Object getUnComment(
            @ApiParam(name="page",value="页码",required=true)@RequestParam(defaultValue = "1")Integer page,
            @ApiParam(name="limit",value="每页条数",required=true)@RequestParam(defaultValue = "10")Integer limit,
            @ApiParam(name="sort",value="以什么为序",required=true)@RequestParam(defaultValue = "gmtCreate") String sort,
            @ApiParam(name="order",value="升/降序",required=true) @RequestParam(defaultValue = "desc") String order)
    {

        Integer userId = Integer.valueOf(request.getHeader("userId"));
        //@RequestBody
        List<Order> ordersVos = orderService.getOrders(userId,Order.StatusCode.PAYED.getValue(),page,limit,sort,order);
        return ResponseUtil.ok(ordersVos);
    }

    /**
     * 确认收货
     *
     * @param orderId 订单ID
     * @return 订单操作结果
     */
    @PostMapping("/orders/{id}/commentResult")
    @ApiOperation(value = "评价订单商品操作结果/comment", notes = "评价订单商品操作结果")
    public Object comment(
            @ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")String orderId ){

        Integer userId = Integer.valueOf(request.getHeader("id"));
        Order order = orderService.getOrder(Integer.parseInt(orderId));

        if(order == null) {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!order.getUserId().equals(userId)) {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        return orderService.comment(userId, Integer.parseInt(orderId));
    }

    @GetMapping(value = "/test")
    public Object test() {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        return cartService.cartIndex(userId);
    }

    /*
    /admin/orders
    RequestParam(userId)，RequestParam (page), RequestParam  (limit), RequestParam(OrderSn),
     RequestParam(List<Short> orderStatusArray)
return List<GetOrdersVo>

    */

    /**
     *提供接口给AfterSale查看orderItem是什么类型
     * @param orderItemId
     * @return
     */
    @GetMapping("orderItem/{orderItemId}/goodsType")
    public Object findOrderItemType(@PathVariable("orderItemId") Integer orderItemId ){
        OrderItem oneItem=orderService.getOrderItem(orderItemId);
        if(oneItem==null){
            return ResponseUtil.fail();
        }
        Integer goodsType= oneItem.getItemType();
        return ResponseUtil.ok(goodsType);
    }

    /**
     * 提供接口给payment回调，修改该订单为付款完成
     * @param id 订单ID
     * @return 是否成功发起支付
     */
    @PutMapping("orders/{id}")
    public Object payOrder(@PathVariable("id")Integer id)
    {
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        if(userId==null){
            return ResponseUtil.unlogin();
        }
        Order oneOrder=orderService.getOrder(id);
        if(oneOrder==null){
            return ResponseUtil.fail();
        }
        HashMap<String,Integer> result=orderService.payOrder(oneOrder);
        if(result.containsKey("orderItem")){
            return ResponseUtil.fail();
        }
        Integer payStatus=result.get("order");
        if(payStatus>-1){
            return ResponseUtil.ok(result);
        }
        else{
            return ResponseUtil.fail();
        }
    }


    /*查询grouponrule的参团人数*/
    @GetMapping("orders/grouponOrders")
    public Object getGrouponNum(@ApiParam(name="grouponRule",value="团购规则",required=true)@PathVariable("grouponRule")
                                            GrouponRule grouponRule ){

        Integer goodId = grouponRule.getGoodsId();
        Integer num = orderService.getGrouponNum(goodId);
        return ResponseUtil.ok(num);
    }



}
