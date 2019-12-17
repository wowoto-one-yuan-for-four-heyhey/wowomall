package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.service.LogisticsService;
import com.xmu.wowoto.wowomall.service.RemoteLogisticsService;
import com.xmu.wowoto.wowomall.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/16 20:11
 */
@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Autowired
    RemoteLogisticsService remoteLogisticsService;

    @Override
    public String getShipSn() {
        String json = remoteLogisticsService.getShipSn();
        return JacksonUtil.parseString(json, "data");
    }
}
