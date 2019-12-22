package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/16 22:29
 */
@Service
@FeignClient("logService")
public interface RemoteLogService {

    /**
     * wowoto
     * @param log
     * @return
     */
    @PostMapping("/log")
    String addLog(@RequestBody Log log);

}
