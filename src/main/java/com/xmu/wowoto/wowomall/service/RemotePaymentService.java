package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Tens  /fringe
 * @Description:
 * @Date: 2019/12/15 20:01
 */
@Service
@FeignClient("paymentService")
public interface RemotePaymentService {

    @PostMapping("payment")
    String createPayment(@RequestBody Payment payment);

    @PutMapping("payment/{id}")
    String payPayment(@PathVariable("id") Integer id);

    /**
     * 根据Id拿到payments
     * @param id
     * @return
     */
    @GetMapping("payment/{id}")
    String getPaymentsById(@PathVariable Integer id);
}
