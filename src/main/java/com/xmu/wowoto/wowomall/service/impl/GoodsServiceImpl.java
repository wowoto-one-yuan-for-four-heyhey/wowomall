package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.dao.GoodsRedis;
import com.xmu.wowoto.wowomall.domain.CartItem;
import com.xmu.wowoto.wowomall.domain.Product;
import com.xmu.wowoto.wowomall.service.GoodsService;
import com.xmu.wowoto.wowomall.service.RemoteGoodsService;
import com.xmu.wowoto.wowomall.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/15 15:06
 */
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    RemoteGoodsService remoteGoodsService;

    @Autowired
    GoodsRedis goodsRedis;

    public Product getProductById(Integer productId){
        String json = remoteGoodsService.getProductById(productId);
        return JacksonUtil.parseObject(json, "data", Product.class);
    }

    @Override
    public boolean deductStock(CartItem cartItem) {
        int safetyStock = cartItem.getProduct().getSafetyStock();
        return false;
    }
}

