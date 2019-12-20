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
import java.util.Map;


/**
 * 定时任务
 * @author fringe
 * @date 12/14/2019
 */
@Component
public class TimerService {

    @Autowired
    OrderDao orderDao;
    @Autowired
    ShareService shareService;
    @Autowired
    UserService userService;

    @Scheduled(cron = "0 49 3 * * ?")
    public void cacuRebate(){
        List<OrderItem> list= orderDao.getRebatingOrderItems();
        for(OrderItem item: list){
            Order order=orderDao.getOrderByOrderId(item.getOrderId());
            List<OrderItem> rebateList=new ArrayList<>();
            rebateList.add(item);
            order.setOrderItemList(rebateList);
            Map<Integer,Integer> result = shareService.getRebate(order);
            System.out.println(result);
            if(result.size()==0){
                continue;
            }
            for(Integer key: result.keySet()){
                Integer value = result.get(key);
                Integer errNo=userService.updateUserRebate(key,value);
            }
        }

    }

}