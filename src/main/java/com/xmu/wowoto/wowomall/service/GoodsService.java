package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.CartItem;
import com.xmu.wowoto.wowomall.domain.OrderItem;
import com.xmu.wowoto.wowomall.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/15 15:04
 */
@Service
public interface GoodsService {

    /**
     * wowoto
     * @param productId
     * @return
     */
    Product getProductById(Integer productId);

    /**
     * wowoto
     * @param cartItem
     * @return
     */
    boolean deductStock(CartItem cartItem);

    /**
     * wowoto
     * @param orderItem
     * @return
     */
    boolean restoreStock(OrderItem orderItem);

}