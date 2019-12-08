package com.xmu.wowoto.wowomall.mapper;

import com.xmu.wowoto.wowomall.WowomallApplication;
import com.xmu.wowoto.wowomall.domain.WowoOrder;
import com.xmu.wowoto.wowomall.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = WowomallApplication.class)
public class OrderMapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    void getOrderByOrderId(){
        WowoOrder wowoOrder = orderMapper.getOrderByOrderId(6);
        System.out.println(wowoOrder);
    }

    @Test
    void updateOrderByOrderId(){
        WowoOrder wowoOrder = new WowoOrder();
        wowoOrder.setId(1);
        wowoOrder.setUserId(100);
        orderMapper.updateOrderSelective(wowoOrder);

        wowoOrder = orderMapper.getOrderByOrderId(1);
        assert wowoOrder.getUserId() == 100;

    }

    @Test
    void updateOrderById(){
        WowoOrder wowoOrder = new WowoOrder();
        wowoOrder.setAddress("厦大学生公寓");
        wowoOrder.setBeDeleted(true);
        wowoOrder.setId(1);
        Integer updateNum = orderMapper.updateOrderSelective(wowoOrder);
    }

    @Test
    void getOrdersByStatusCode(){
        List<WowoOrder> WowoOrderList=orderMapper.getOrdersByStatusCode(1,0,1,10,"gmtCreate","desc");
        for(WowoOrder oneOrder:WowoOrderList)
        {
            /**
             *等待数据
             */
        }
    }
}
