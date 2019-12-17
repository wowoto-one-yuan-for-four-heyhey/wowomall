package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.domain.Payment;
import com.xmu.wowoto.wowomall.service.PaymentService;
import com.xmu.wowoto.wowomall.service.RemotePaymentService;
import com.xmu.wowoto.wowomall.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/15 20:05
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    RemotePaymentService remotePaymentService;

    @Override
    public Payment createPayment(Payment payment) {
        String json = remotePaymentService.createPayment(payment);
        return JacksonUtil.parseObject(json, "data", Payment.class);
    }

    @Override
    public Payment payPayment(Integer id) {
        String json = remotePaymentService.payPayment(id);
        return JacksonUtil.parseObject(json, "data", Payment.class);
    }

    /**
     * 根据ID拿到payment
     * @param paymentId
     * @return
     */
    @Override
    public List<Payment> getPaymentById(Integer paymentId)
    {
        String json= remotePaymentService.getPaymentById(paymentId);
        List<Payment> list= JacksonUtil.parseObject(json,"data",List.class);
        return list;
    }
}
