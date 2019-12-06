package com.xmu.wowoto.wowomall.controller;

import com.xmu.wowoto.wowomall.controller.vo.SubmitOrderVo;
import com.xmu.wowoto.wowomall.domain.WowoAddress;
import com.xmu.wowoto.wowomall.domain.WowoCartItem;
import com.xmu.wowoto.wowomall.domain.WowoOrder;
import com.xmu.wowoto.wowomall.service.CartItemService;
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
    private CartItemService cartItemService;

    @PostMapping("order")
    public Object submit(@RequestBody SubmitOrderVo submitOrderVo){

        logger.debug("submit: " + submitOrderVo);

        WowoOrder wowoOrder = new WowoOrder();
        wowoOrder.setWowoAddress((WowoAddress) submitOrderVo.getAddress());

        List<WowoCartItem> wowoCartItems = new ArrayList<>(submitOrderVo.getCartItemIds().size());
        for(Integer cartItemId: submitOrderVo.getCartItemIds()){
            WowoCartItem wowoCartItem = cartItemService.findCartItemById(cartItemId);
            wowoCartItems.add(wowoCartItem);
        }

        wowoOrder = orderService.submit(wowoOrder, wowoCartItems);

        return ResponseUtil.ok(wowoOrder);
    }


    @PostMapping("orders/{id}/ship")
    public Object shipOrder(@ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")String orderId){
        // orderItem
        return orderService.updateOrderStatusById(Integer.parseInt(orderId), WowoOrder.STATUSCODE.NOT_TAKEN.getValue());
    }

    @PostMapping("orders/{id}/refund")
    public Object refundOrder(@ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")String orderId){
        // orderItem
        return orderService.updateOrderStatusById(Integer.parseInt(orderId), WowoOrder.STATUSCODE.REFUND.getValue());
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
    @ApiOperation("查看用户的全部订单")
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
     * @param orderId 订单ID
     * @return 订单详细
     */
    @GetMapping("orders/{id}")
    @ApiOperation("查看特定订单的订单详情")
    public Object getOrderDetail(@ApiParam(name="orderId",value="订单id",required=true)@PathVariable("id")String orderId)
    {
        int id = Integer.parseInt(orderId);
        return orderService.getOrderDetail(id);
    }
}
