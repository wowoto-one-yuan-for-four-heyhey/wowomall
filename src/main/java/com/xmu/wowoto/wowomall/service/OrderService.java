package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.WowoCartItem;
import com.xmu.wowoto.wowomall.domain.WowoOrder;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Service
public interface OrderService {

    /**
     * 提交订单
     * @param wowoOrder 新订单
     * @param wowoCartItems 购物车中加入订单的货品
     * @return 新产生的订单
     */
    public WowoOrder submit(WowoOrder wowoOrder, List<WowoCartItem> wowoCartItems);

    /**
     * 获取用户订单列表
     *
     * @param userId   用户ID
     * @param statusCode 订单信息
     * @param page     分页页数
     * @param limit     分页大小
     * @return 订单列表
     */
    public List<Map<String,Object>> getOrders(Integer userId, Integer statusCode, Integer page, Integer limit, String sort, String order);

    /**
     * 获取用户特定订单详情
     *
     * @param userId   用户ID
     * @param orderId 订单ID
     * @return 订单详细
     */
    public Object getOrderDetail( Integer userId,Integer orderId);

    public Object getOrderDetail(Integer orderId);


}
