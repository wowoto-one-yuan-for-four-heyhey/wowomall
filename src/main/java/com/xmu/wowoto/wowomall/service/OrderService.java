package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public void deleteOrder(int orderId);
}
