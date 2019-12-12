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
        WowoOrder wowoOrder = new WowoOrder();
        wowoOrder.setUserId(0);
        wowoOrder.setStatusCode(0);
        wowoOrder.setMobile("13988888888");
        wowoOrder.setMessage("Test");
        wowoOrder.setWowoOrderItems(new ArrayList<>());

        WowoOrderItem item1 = new WowoOrderItem();
        item1.setProductId(1);
        item1.setNumber(2);
        WowoOrderItem item2 = new WowoOrderItem();
        item2.setProductId(3);
        item2.setNumber(4);

        wowoOrder.getWowoOrderItems().add(item1);
        wowoOrder.getWowoOrderItems().add(item2);

        orderDao.addOrder(wowoOrder);
    }
}
