package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Service
public interface GoodsService {
    /**
     *根据prodductId拿到product
     * @param productId
     */
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer productId);
}
