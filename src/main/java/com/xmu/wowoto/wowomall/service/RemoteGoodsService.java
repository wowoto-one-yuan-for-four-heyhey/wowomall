package com.xmu.wowoto.wowomall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/12 22:56
 */

@Service
@FeignClient("GoodsInfo")
public interface RemoteGoodsService {
    @GetMapping("products/{id}")
    String getProductById(@PathVariable("id") Integer productId);
}
