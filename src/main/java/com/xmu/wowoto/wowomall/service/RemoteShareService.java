package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: fringe
 * @Description:
 * @Date: 2019/12/15 20:58
 */
@Service
@FeignClient("ShareService")
public interface RemoteShareService {

    /**
     * 计算order中orderItem对应的返点
     * @param order
     * @return
     */
    @GetMapping(value="")
    String getRebate(Order order);

}
