package com.xmu.wowoto.wowomall.service;


import com.xmu.wowoto.wowomall.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Service
@FeignClient("payment")
public interface PaymentService {
     @PostMapping(value= "payments")
     Payment addPayment();
}
