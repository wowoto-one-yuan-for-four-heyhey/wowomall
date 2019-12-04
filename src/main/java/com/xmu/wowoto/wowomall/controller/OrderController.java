package com.xmu.wowoto.wowomall.controller;

import com.xmu.wowoto.wowomall.controller.vo.SubmitOrderVo;
import com.xmu.wowoto.wowomall.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Api(value="Order",tags = "订单")
@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping("order")
    public Object submit(@RequestBody SubmitOrderVo submitOrderVo){

        logger.debug("submit: " + submitOrderVo);


        return ResponseUtil.ok();
    }
}
