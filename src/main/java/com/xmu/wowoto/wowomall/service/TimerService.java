package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.dao.OrderDao;
import com.xmu.wowoto.wowomall.domain.Order;
import com.xmu.wowoto.wowomall.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 定时任务
 * @author K
 * @date 12/14/2019
 */
@Component
public class TimerService {

    @Autowired
    OrderDao orderDao;

    @Scheduled(cron = "0 0 2 * * ?")
    public void cacuRebate(){
        List<OrderItem> list= orderDao.getRebatingOrderItems();
        for(OrderItem item: list){
            Order order=orderDao.getOrderByOrderId(item.getOrderId());
            List<OrderItem> rebateList=new ArrayList<>();
            rebateList.add(item);

        }

    }

}