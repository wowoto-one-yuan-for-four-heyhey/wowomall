package com.xmu.wowoto.wowomall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient
public interface RemoteCart {

    /**
     * dsf a
     * @param UserId
     * @return
     */
    @GetMapping("carts")
    Object cartIndex(Integer UserId);
}
