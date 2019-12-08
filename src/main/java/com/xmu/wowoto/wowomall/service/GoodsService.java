package com.xmu.wowoto.wowomall.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
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
