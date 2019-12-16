package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/16 19:56
 */
@Service
public interface FreightService {

    BigDecimal caculateFreight(Order order);
}
