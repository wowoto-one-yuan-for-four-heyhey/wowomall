package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.WowomallApplication;
import com.xmu.wowoto.wowomall.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WowomallApplication.class)
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    void getOrderDetail(){
        orderService.getOrderDetail(2, 2);
    }
}
