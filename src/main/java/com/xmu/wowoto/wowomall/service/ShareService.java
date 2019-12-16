package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Order;
import com.xmu.wowoto.wowomall.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;


/**
 * @Author: /fringe
 * @Description:
 * @Date: 2019/12/15 20:23
 */
@Service
public interface ShareService {

    /**
     * 计算订单对应返点
     * @param order
     * @return
     */
    Map<Integer,Integer> getRebate(Order order);
}
