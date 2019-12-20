package com.xmu.wowoto.wowomall.util;

/**
 *
 * @author wowoto
 * @date 12/11/2019
 */
public enum ResponseCode {
    ORDER_INVAILD(600,"该订单是无效订单"),
    ORDER_PAIMENT_FAILED(601,"订单支付失败"),
    ORDER_SUBMIT_FAILED(602,"订单提交失败"),
    ORDER_COMMENTED(603,"订单已被评论"),
    ORDER_INVAILD_OPERATION(604,"订单非法操作"),
    ORDER_EXCHANGE_FAILED(605,"订单换货请求失败"),
    ORDER_RETURN_FAILED(606,"订单退货请求失败"),
    ORDER_STATUS_CHANGE_FAILED(607,"订单修改状态失败"),
    REBATE_FAILED(608,"使用返点失败"),
    COUPON_FAILED(609,"使用优惠券失败")

    ;

    private final Integer code;
    private final String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
