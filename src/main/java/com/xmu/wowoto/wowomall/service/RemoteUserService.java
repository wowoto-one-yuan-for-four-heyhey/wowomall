package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Tens /fringe
 * @Description:
 * @Date: 2019/12/15 20:23
 */
@Service
@FeignClient("UserInfo")
public interface RemoteUserService {

    @GetMapping("user/{id}")
    String getUserById(@PathVariable("id") Integer userId);

    @PutMapping("user/rebate")
    String updateRebate(Integer userId, Integer rebate);

}
