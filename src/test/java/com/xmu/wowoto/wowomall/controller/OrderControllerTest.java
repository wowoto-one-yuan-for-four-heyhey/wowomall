package com.xmu.wowoto.wowomall.controller;

import com.xmu.wowoto.wowomall.WowomallApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(classes = WowomallApplication.class)
public class OrderControllerTest {

    @Autowired
    private OrderController orderController;



}
