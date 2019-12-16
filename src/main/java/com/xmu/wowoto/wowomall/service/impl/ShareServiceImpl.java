package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.domain.Order;
import com.xmu.wowoto.wowomall.service.RemoteShareService;
import com.xmu.wowoto.wowomall.service.ShareService;
import com.xmu.wowoto.wowomall.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author: fringe
 * @Description:
 * @Date: 2019/12/15 20:28
 */
public class ShareServiceImpl implements ShareService {

    @Autowired
    RemoteShareService remoteShareService;
    /**
     * 计算订单对应返点
     * @param order
     * @return
     */
    @Override
    public Map<Integer,Integer> getRebate(Order order){
        String json=remoteShareService.getRebate(order);
        Map<Integer,Integer> result= JacksonUtil.parseObject(json, "data", Map.class);
        return result;
    }
}
