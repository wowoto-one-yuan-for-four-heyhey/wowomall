package com.xmu.wowoto.wowomall.service;

import org.springframework.stereotype.Service;

@Service
public interface GoodsService {
    /**
     * 扣减货品库存量
     * @param productId
     * @param quantity
     * @return
     */
    public Boolean deductStock(Integer productId, Integer quantity);
}
