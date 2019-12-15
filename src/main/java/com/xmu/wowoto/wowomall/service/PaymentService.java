package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Payment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/15 20:01
 */
@Service
public interface PaymentService {

    Payment createPayment(Payment payment);

}
