package com.xmu.wowoto.wowomall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Tens /fringe
 * @Description:
 * @Date: 2019/12/15 20:23
 */
@Service
@FeignClient("userInfoService")
public interface RemoteUserService {

    /**
     * wowoto
     * @param userId
     * @return
     */
    @GetMapping("in/user")
    String getUserById(@RequestParam Integer userId);

    /**
     * wowoto
     * @param userId
     * @param rebate
     * @return
     */
    @PutMapping("user/rebate")
    String updateUserRebate(@RequestParam("id") Integer userId, @RequestParam("userRebate") Integer rebate);
}
