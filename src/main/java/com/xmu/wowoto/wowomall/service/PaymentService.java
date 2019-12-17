package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Payment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
     * 根据ID拿到payment
     * @param id
     * @return
     */
     List<Payment> getPaymentById(Integer id);

    Payment payPayment(Integer id);

}
