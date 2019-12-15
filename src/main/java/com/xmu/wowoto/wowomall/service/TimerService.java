package com.xmu.wowoto.wowomall.service;

import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 定时任务
 * @author K
 * @date 12/14/2019
 */
@Component
public class TimerService {


    @Scheduled(cron = "5 19 20 * * ?")
    public void cacuRebate(){
        List<Order> orderList
    }

}