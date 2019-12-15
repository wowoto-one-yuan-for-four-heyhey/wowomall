package com.xmu.wowoto.wowomall.dao;

import com.xmu.wowoto.wowomall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodsRedis {

    @Autowired
    RedisUtil redisUtil;

    boolean deductStock(Integer productId, Integer number){
        String key = "Stock" + productId;
        String value = redisUtil.get(key);

        Integer stock;
        if(value != null){
            stock = Integer.parseInt(value);
            if(stock >= number){
                stock -= number;
                redisUtil.set(key, String.valueOf(stock));
            }
        }

    }

    boolean supplyStock(Integer product, Integer number){

    }

}
