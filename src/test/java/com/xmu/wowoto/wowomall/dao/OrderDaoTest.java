package com.xmu.wowoto.wowomall.dao;

import com.xmu.wowoto.wowomall.WowomallApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest(classes = WowomallApplication.class)
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    void addOrderTest(){

    }
}
