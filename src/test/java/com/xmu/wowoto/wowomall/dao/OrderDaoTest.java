package com.xmu.wowoto.wowomall.dao;

import com.xmu.wowoto.wowomall.WowomallApplication;
import com.xmu.wowoto.wowomall.domain.WowoOrder;
import com.xmu.wowoto.wowomall.domain.WowoOrderItem;
import com.xmu.wowoto.wowomall.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = WowomallApplication.class)
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    void addOrderTest(){
        WowoOrder wowoOrder = new WowoOrder();
        wowoOrder.setUserId(0);
        wowoOrder.setStatusCode(0);
        wowoOrder.setMobile("13988888888");
        wowoOrder.setMessage("Test");

        WowoOrderItem item1 = new WowoOrderItem();


        orderDao.addOrder(wowoOrder);
    }
}
