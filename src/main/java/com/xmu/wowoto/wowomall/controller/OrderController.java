package com.xmu.wowoto.wowomall.controller;

import com.xmu.wowoto.wowomall.controller.vo.GetOrdersVo;
import com.xmu.wowoto.wowomall.controller.vo.OrderItemVo;
import com.xmu.wowoto.wowomall.controller.vo.ProductVo;
import com.xmu.wowoto.wowomall.controller.vo.SubmitOrderVo;
import com.xmu.wowoto.wowomall.domain.Order;
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
     * @param statusCode 订单信息
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    @GetMapping("orders")
    @ApiOperation(value = "用户获取订单列表/list", notes = "用户获取订单列表")
    public Object getOrders(@ApiParam(name="showType",value="订单状态信息",required=true) @RequestParam(defaultValue = "0")Integer statusCode,
                                       @ApiParam(name="page",value="页码",required=true) @RequestParam(defaultValue = "1")Integer page,
                                       @ApiParam(name="limit",value="每页条数",required=true) @RequestParam(defaultValue = "10")Integer limit,
                                       @ApiParam(name="sort",value="以什么为序",required=true) @RequestParam(defaultValue = "add_time") String sort,
                                       @ApiParam(name="order",value="升/降序",required=true) @RequestParam(defaultValue = "desc") String order)
    {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(null == userId) {
            return ResponseUtil.unlogin();
        }
        List<Order> orders = orderService.getOrders(userId,statusCode,page,limit,sort,order);
        List<GetOrdersVo> getOrdersVos = new ArrayList<>(wowoOrders.size());
        for (int i = 0; i < wowoOrders.size(); i++){
            GetOrdersVo getOrdersVo = getOrdersVos.get(i);
            WowoOrder wowoOrder = wowoOrders.get(i);
            getOrdersVo.setOrder(wowoOrder);
            getOrdersVo.setAddress(wowoOrder.getWowoAddress());
            List<OrderItemVo> orderItemVos = new ArrayList<>(wowoOrder.getWowoOrderItems().size());
            for (int j = 0; j < orderItemVos.size(); j++){
                WowoOrderItem wowoOrderItem = wowoOrder.getWowoOrderItems().get(j);
                OrderItemVo orderItemVo = orderItemVos.get(j);
                orderItemVo.setOrderItem(wowoOrderItem);
                ProductVo productVo = new ProductVo();
                productVo.setProduct(wowoOrderItem.getWowoProduct());
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
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(userId == null) {
            ResponseUtil.unlogin();
        }
        Order wowoOrder = orderService.getOrder(orderId);

        if(wowoOrder == null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!wowoOrder.getUserId().equals(userId))
        {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }

        GetOrdersVo getOrdersVo = new GetOrdersVo();
        getOrdersVo.setOrder(wowoOrder);
        getOrdersVo.setAddress(wowoOrder.getWowoAddress());
        List<OrderItemVo> orderItemVos = new ArrayList<>(wowoOrder.getWowoOrderItems().size());
        for (int i = 0; i < orderItemVos.size(); i++){
            OrderItemVo orderItemVo = orderItemVos.get(i);
            WowoOrderItem wowoOrderItem = wowoOrder.getWowoOrderItems().get(i);
            orderItemVo.setOrderItem(wowoOrderItem);
            ProductVo productVo = new ProductVo();
            productVo.setProduct(wowoOrderItem.getWowoProduct());
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

        Integer userId = Integer.valueOf(request.getHeader("id"));
        logger.debug("submit: " + submitOrderVo);
        if(null == userId)
        {   return ResponseUtil.unlogin();}
        if(null == submitOrderVo) {
            return ResponseUtil.badArgument();
        }
        WowoOrder wowoOrder = new WowoOrder();
        wowoOrder.setWowoAddress((WowoAddress) submitOrderVo.getAddress());

        if(null != submitOrderVo.getCouponId()){
            WowoCoupon wowoCoupon = couponService.findCouponById(submitOrderVo.getCouponId());
            wowoOrder.setWowoCoupon(wowoCoupon);
        }

        List<WowoCartItem> wowoCartItems = new ArrayList<>(submitOrderVo.getCartItemIds().size());
        for(Integer cartItemId: submitOrderVo.getCartItemIds()){
            WowoCartItem wowoCartItem = cartService.findCartItemById(cartItemId);
            wowoCartItems.add(wowoCartItem);
        }

        wowoOrder = orderService.submit(wowoOrder, wowoCartItems);

        return ResponseUtil.ok(wowoOrder);
    }

    /**
     * 取消订单
     *
     * @param orderId   订单ID
     * @return 取消订单操作结果
     */
    @PutMapping("orders/{id}/cancel")
    @ApiOperation(value = "取消订单操作结果/cancel", notes = "取消订单操作结果")
    public Object cancelOrder( @PathVariable("id")String orderId, @RequestBody Order order) {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(null == userId) {
            return ResponseUtil.unlogin();
        }
        Order wowoOrder = orderService.getOrder(Integer.parseInt(orderId));

        if(wowoOrder == null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!wowoOrder.getUserId().equals(userId))
        {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        return orderService.cancelOrder(userId, Integer.parseInt(orderId));
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
        Integer userId = Integer.valueOf(request.getHeader("id"));
        if(null == userId) {
            return ResponseUtil.unlogin();
        }
        Order wowoOrder = orderService.getOrder(Integer.parseInt(orderId));

        if(wowoOrder == null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!wowoOrder.getUserId().equals(userId))
        {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        return orderService.deleteOrder(userId, Integer.parseInt(orderId));
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
        Integer userId = Integer.valueOf(request.getHeader("id"));
        Order wowoOrder = orderService.getOrder(Integer.parseInt(orderId));

        if(wowoOrder == null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!wowoOrder.getUserId().equals(userId))
        {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        return orderService.confirm(userId, Integer.parseInt(orderId));
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
        Integer userId = Integer.valueOf(request.getHeader("id"));
        Order wowoOrder = orderService.getOrder(Integer.parseInt(orderId));

        if(wowoOrder == null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!wowoOrder.getUserId().equals(userId))
        {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        return orderService.shipOrder(userId,Integer.parseInt(orderId));
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
        Integer userId = Integer.valueOf(request.getHeader("id"));
        Order wowoOrder = orderService.getOrder(Integer.parseInt(orderId));

        if(wowoOrder == null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!wowoOrder.getUserId().equals(userId))
        {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        return orderService.refundOrder(userId,Integer.parseInt(orderId));
    }

    /**
     * 用户点击支付,在本服务里检验权限，后续调用payment"
     * @param id 订单ID
     * statusCode PAYED
     * @return 是否成功发起支付
     */
    @PutMapping("orders/{id}/payment")
    @ApiOperation("订单成功支付(内部接口，供paymentService调用")
    public Object payOrder(
                           @ApiParam(name="id",value="订单id",required=true)@PathVariable("id")String id)
    {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        return true;
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

        Integer userId = Integer.valueOf(request.getHeader("id"));
        //@RequestBody
        return orderService.getOrders(userId,WowoOrder.STATUSCODE.NOT_COMMENTED.getValue(),page,limit,sort,order);
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
        Order wowoOrder = orderService.getOrder(Integer.parseInt(orderId));

        if(wowoOrder == null)
        {
            return ResponseUtil.fail(ORDER_UNKNOWN.getCode() ,ORDER_UNKNOWN.getMessage());
        }
        if(!wowoOrder.getUserId().equals(userId))
        {
            return ResponseUtil.fail(ORDER_INVALID_OPERATION.getCode() ,ORDER_INVALID_OPERATION.getMessage());
        }
        return orderService.comment(userId, Integer.parseInt(orderId));
    }

    @GetMapping(value = "/test")
    public Object test() {
        Integer userId = Integer.valueOf(request.getHeader("id"));
        return cartService.cartIndex(userId);
    }

}
