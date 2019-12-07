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
        WowoOrder wowoOrder = orderMapper.getOrderByOrderId(0);
        assert wowoOrder.getId() == 0;
        assert wowoOrder.getUserId() == 0;
        assert wowoOrder.getBeSharedItemIds().equals("0");
        assert wowoOrder.getOrderSn().equals("别改");
    }

    @Test
    void updateOrderByOrderId(){
        WowoOrder wowoOrder = new WowoOrder();
        wowoOrder.setId(1);
        wowoOrder.setUserId(100);
        orderMapper.updateOrderByIdSelective(wowoOrder);

        wowoOrder = orderMapper.getOrderByOrderId(1);
        assert wowoOrder.getUserId() == 100;

    }

    @Test
    void updateOrderById(){
        WowoOrder wowoOrder = new WowoOrder();
        wowoOrder.setAddress("厦大学生公寓");
        wowoOrder.setId(1);
        Integer updateNum = orderMapper.updateOrderByIdSelective(wowoOrder);
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
