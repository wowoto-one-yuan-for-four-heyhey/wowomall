package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/15 20:01
 */
@Service
@FeignClient("payment")
public interface RemotePaymentService {

    @PostMapping("payment")
    String createPayment(@RequestBody Payment payment);

    @PutMapping("payment/{id}")
    String payPayment(@PathVariable("id") Integer id);

}
