package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/16 19:50
 */
@Service
@FeignClient("Freight")
public interface RemoteFreightService {

    @PostMapping("/freightPrice")
    String caculateFreight(Order order);
}
