package com.xmu.wowoto.wowomall.service;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/16 20:08
 */
@Service
@FeignClient("logisticsService")
public interface RemoteLogisticsService {

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GetMapping(value = "/logistics")
    String getShipSn();
}
