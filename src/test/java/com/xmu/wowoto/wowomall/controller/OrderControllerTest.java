package com.xmu.wowoto.wowomall.controller;

import com.xmu.wowoto.wowomall.WowomallApplication;
import com.xmu.wowoto.wowomall.dao.OrderDao;
import com.xmu.wowoto.wowomall.domain.WowoOrder;
import com.xmu.wowoto.wowomall.util.JacksonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = WowomallApplication.class)
public class OrderControllerTest {

    @Autowired
    private OrderController orderController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getOrders(){
        Object wowoOrderList=orderController.getOrders(2,0,1,10,"gmtCreate","desc");

        String responseString = this.mockMvc.perform(post("/orders").contentType("application/json;charset=UTF-8").content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();


        String errMsg = JacksonUtil.parseObject(responseString,"errmsg", String.class);
        Integer errNo = JacksonUtil.parseObject(responseString,"errno", Integer.class);
        Order order = JacksonUtil.parseObject(responseString,"data", Order.class);
    }


}
