package com.xmu.wowoto.wowomall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/16 20:08
 */
@Service
@FeignClient("logistics")
public interface RemoteLogisticsService {

    @GetMapping("/logistics")
    String getShipSn();
}
