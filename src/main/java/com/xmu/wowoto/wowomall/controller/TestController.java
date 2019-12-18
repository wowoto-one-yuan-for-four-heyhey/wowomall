package com.xmu.wowoto.wowomall.controller;

import com.xmu.wowoto.wowomall.service.RemoteAftersalesService;
import com.xmu.wowoto.wowomall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/18 16:21
 */
@RestController
public class TestController {
    @Autowired
    RemoteAftersalesService remoteAftersalesService;

    @GetMapping("test")
    public Object test(){
        String s = remoteAftersalesService.getAftersales(1);
        return ResponseUtil.ok();
    }
}
