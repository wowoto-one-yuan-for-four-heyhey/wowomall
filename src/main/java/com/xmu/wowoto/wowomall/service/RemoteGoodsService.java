package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/12 22:56
 */

@Service
@FeignClient("goodsInfoService")
public interface RemoteGoodsService {
    @GetMapping("products/{id}")
    String getProductById(@PathVariable("id") Integer productId);

    @PutMapping("products/{id}")
    String updateProductById(@PathVariable("id") Integer productId, Product product);
}
