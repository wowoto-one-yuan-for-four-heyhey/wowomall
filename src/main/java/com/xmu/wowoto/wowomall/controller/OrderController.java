package com.xmu.wowoto.wowomall.controller;

import com.xmu.wowoto.wowomall.controller.vo.SubmitOrderVo;
import com.xmu.wowoto.wowomall.domain.WowoAddress;
import com.xmu.wowoto.wowomall.domain.WowoCartItem;
import com.xmu.wowoto.wowomall.domain.WowoCoupon;
import com.xmu.wowoto.wowomall.domain.WowoOrder;
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



import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("orders")
    public Object submit(@RequestBody SubmitOrderVo submitOrderVo){

        logger.debug("submit: " + submitOrderVo);

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
     * 更改订单状态为发货(管理员操作)
     *
     * @param orderId   订单ID
     * @return 更改列表

     */
    @PostMapping("orders/{id}/ship")
    @ApiOperation("更改订单状态为发货(管理员操作)")
    public Object shipOrder(Integer userId,@ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")String orderId){
        // orderItem
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
    public Object refundOrder(Integer userId,@ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")String orderId){

        return orderService.refundOrder(userId,Integer.parseInt(orderId));
    }

    /**
     * 获取用户订单列表
     *
     * @param userId   用户ID
     * @param statusCode 订单信息
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    @GetMapping("orders")
    @ApiOperation("查看用户的全部订单(用户)")
    public Object getOrders(Integer userId,
                      @ApiParam(name="showType",value="订单状态信息",required=true)@RequestParam(defaultValue = "0")Integer statusCode,
                      @ApiParam(name="page",value="页码",required=true)@RequestParam(defaultValue = "1")Integer page,
                      @ApiParam(name="limit",value="每页条数",required=true)@RequestParam(defaultValue = "10")Integer limit,
                      @ApiParam(name="sort",value="以什么为序",required=true)@RequestParam(defaultValue = "pay_time") String sort,
                      @ApiParam(name="order",value="升/降序",required=true) @RequestParam(defaultValue = "desc") String order)
    {
        return orderService.getOrders(userId,statusCode,page,limit,sort,order);
    }

    /**
     * 获取用户特定订单详情
     * @param id 订单ID
     * @return 订单详细
     */
    @GetMapping("orders/{id}")
    @ApiOperation("查看特定订单的订单详情(用户)")
    public Object getOrderDetail( Integer userId,
                                  @ApiParam(name="id",value="订单id",required=true)@PathVariable("id")String id)
    {
        Integer id2 = Integer.parseInt(id);
        return orderService.getOrderDetail(userId,id2);
    }

    /**
     * 提供给支付模块修改订单状态->支付成功  (供paymentService调用)"
     * @param userId 用户ID
     * @param id 订单ID
     * statusCode PAYED
     * @return 是否成功
     */
    @PutMapping("orders/{id}/payment")
    @ApiOperation("订单成功支付(内部接口，供paymentService调用")
    public Object payOrder(Integer userId,
                           @ApiParam(name="id",value="订单id",required=true)@PathVariable("id")String id
                           )
    {
        return true;
    }



    /**
     * 待评价订单商品信息/goods (用户操作)
     * @param userId 用户ID
     * @param limit 每页条数
     * @param page 页码
     * @param sort 以什么为序
     * @param order 升/降序
     * @return 订单详细
     */
    @GetMapping("orders/unevaluated")
    @ApiOperation("查看未评价订单的订单详情")
    public Object getUnComment(Integer userId,
                               @ApiParam(name="page",value="页码",required=true)@RequestParam(defaultValue = "1")Integer page,
                               @ApiParam(name="limit",value="每页条数",required=true)@RequestParam(defaultValue = "10")Integer limit,
                               @ApiParam(name="sort",value="以什么为序",required=true)@RequestParam(defaultValue = "gmtCreate") String sort,
                               @ApiParam(name="order",value="升/降序",required=true) @RequestParam(defaultValue = "desc") String order)
    {

        //@RequestBody
        return orderService.getOrders(userId,WowoOrder.STATUSCODE.NOT_COMMENTED.getValue(),page,limit,sort,order);
    }

    /**
     * 取消一个订单(管理员操作)
     *
     * @param orderId   订单ID
     * @return 更改列表

     */
    @DeleteMapping("orders/{id}")
    @ApiOperation("取消一个订单")
    public Object cancelOrder(Integer userId,
                              @ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")String orderId) {
        return orderService.deleteOrder(userId, Integer.parseInt(orderId));
    }

    /**
     * 确认收货
     *
     * @param userId 用户ID
     * @param orderId 订单ID
     * @return 订单操作结果
     */
    @PostMapping("orders/{id}/confirm")
    @ApiOperation(value = "确认收货订单操作结果/confirm")
    public Object confirm(Integer userId,
                          @ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")String orderId){
        return orderService.confirm(userId, Integer.parseInt(orderId));
    }




}
