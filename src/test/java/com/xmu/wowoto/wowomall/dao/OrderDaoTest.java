package com.xmu.wowoto.wowomall.dao;

import com.xmu.wowoto.wowomall.WowomallApplication;
import com.xmu.wowoto.wowomall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WowomallApplication.class)
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;
}
