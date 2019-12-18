package com.xmu.wowoto.wowomall.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/18 11:02
 */
@ControllerAdvice
@ResponseBody
public class GlobalException {
    @ExceptionHandler
    public Object runtimeExceptionHandler(RuntimeException ex){
        return ResponseUtil.serious();
    }
}
