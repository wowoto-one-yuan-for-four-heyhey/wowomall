package com.xmu.wowoto.wowomall.controller.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderVo {
    private Integer id;
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 订单序号
     */
    private String orderSn;
    /**
     * 订单状态，1未付款，2未发货，3未收获，4未评价，5已完成订单，6退货订单，7换货订单
     */
    private Short statusCode;
    /**
     * 订单费用
     */
    private BigDecimal goodPrice;
    /**
     * 是否是团购订单
     */
    private Integer isGroupin;

    public Integer getId() {
        return id;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public Short getStatusCode() {
        return statusCode;
    }
}
