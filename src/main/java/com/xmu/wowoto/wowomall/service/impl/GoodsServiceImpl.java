package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Override
    public Boolean deductStock(Integer productId, Integer quantity) {
        return true;
    }
}
