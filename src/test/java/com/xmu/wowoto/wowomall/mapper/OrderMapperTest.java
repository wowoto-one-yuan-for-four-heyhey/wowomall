package com.xmu.wowoto.wowomall.mapper;

import com.xmu.wowoto.wowomall.WowomallApplication;
import com.xmu.wowoto.wowomall.domain.WowoOrder;
import com.xmu.wowoto.wowomall.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WowomallApplication.class)
public class OrderMapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    void getOrderByOrderId(){
        WowoOrder wowoOrder = orderMapper.getOrderByOrderId(1);

    }

    @Test
    void updateOrderById(){
        WowoOrder wowoOrder = new WowoOrder();
        wowoOrder.setAddress("'厦大学生公寓'");
        wowoOrder.setBeDeleted(1);
        wowoOrder.setId(1);
        Integer updateNum = orderMapper.updateOrderByIdSelective(wowoOrder);
    }
}
