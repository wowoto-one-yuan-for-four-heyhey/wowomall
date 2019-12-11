package com.xmu.wowoto.wowomall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("wowoto-cart")
public interface RemoteCart {

    /**
     * dsf a
     * @param userId
     * @return
     */
    @RequestMapping(value = "/carts", method = RequestMethod.GET)
    Object cartIndex(@RequestParam(value = "userId") Integer userId);
}
