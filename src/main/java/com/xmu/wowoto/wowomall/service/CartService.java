package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */

@Service
public interface CartService {
    /**
     * 用ID获得CartItem对象
     * @param id 对象ID
     * @return CartItem
     */
    CartItem findCartItemById(Integer id);

    /**
     * 清空购物车里的指定项目
     * @param cartItems 待清空的项目
     */
    boolean clearCartItem(List<CartItem> cartItems);
}
