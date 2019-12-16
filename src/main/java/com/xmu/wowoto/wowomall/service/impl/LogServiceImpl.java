package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.domain.Log;
import com.xmu.wowoto.wowomall.service.LogService;
import com.xmu.wowoto.wowomall.service.RemoteLogService;
import com.xmu.wowoto.wowomall.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/16 22:31
 */
public class LogServiceImpl implements LogService {

    @Autowired
    RemoteLogService remoteLogService;

    @Override
    public Log addLog(Log log) {
        String json = remoteLogService.addLog(log);
        return JacksonUtil.parseObject(json, "data", Log.class);
    }
}
