package com.xmu.wowoto.wowomall.util;

public enum ResponseCode {
    AUTH_INVALID_ACCOUNT(700, ""),

    ORDER_UNKNOWN(720, "订单不存在"),
    ORDER_INVALID(721, "订单异常"),
    ORDER_INVALID_OPERATION(725, "订单非法操作")


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
