package com.xmu.wowoto.wowomall.mapper;

import com.xmu.wowoto.wowomall.WowomallApplication;
import com.xmu.wowoto.wowomall.domain.WowoOrder;
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
}
