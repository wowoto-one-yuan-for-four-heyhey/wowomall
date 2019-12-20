package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Payment;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author: Tens  / fringe
 * @Description:
 * @Date: 2019/12/15 20:01
 */
@Service
public interface PaymentService {
    /**
     * 添加一条payment
     * @param payment
     * @return
     */
    Payment createPayment(Payment payment);

    /**
     * 根据orderId拿到payment
     * @param orderId
     * @return
     */
    List<Payment> getPaymentByOrderId(Integer orderId);

    Payment payPayment(Integer id);



}
