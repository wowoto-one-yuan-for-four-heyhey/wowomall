package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: fringe
 * @Description:
 * @Date: 2019/12/15 20:58
 */
@Service
@FeignClient("shareService")
public interface RemoteShareService {

    /**
     * 计算order中orderItem对应的返点
     * @param order
     * @return
     */
    @PostMapping(value="/rebate")
    String getRebate(Order order);

}
