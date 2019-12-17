package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.domain.Order;
import com.xmu.wowoto.wowomall.service.FreightService;
import com.xmu.wowoto.wowomall.service.RemoteFreightService;
import com.xmu.wowoto.wowomall.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/16 19:57
 */
@Service
public class FreightServiceImpl implements FreightService {
    @Autowired
    RemoteFreightService remoteFreightService;

    @Override
    public BigDecimal caculateFreight(Order order) {
        String json = remoteFreightService.caculateFreight(order);
        return JacksonUtil.parseObject(json, "data", BigDecimal.class);
    }
}
