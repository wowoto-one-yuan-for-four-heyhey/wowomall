package com.xmu.wowoto.wowomall.mapper;

import com.xmu.wowoto.wowomall.WowomallApplication;
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

    }

    @Test
    void updateOrderByOrderId(){

    }

    @Test
    void updateOrderById(){

    }

    @Test
    void getOrdersByStatusCode(){

    }
}
