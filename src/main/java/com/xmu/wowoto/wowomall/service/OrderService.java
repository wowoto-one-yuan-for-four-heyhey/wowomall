package com.xmu.wowoto.wowomall.service;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public Object getOrders(Integer userId, Integer statusCode, Integer page, Integer limit,String sort,String order);

}
