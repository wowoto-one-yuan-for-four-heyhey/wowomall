package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.WowoCartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    /**
     * 用ID获得CartItem对象
     * @param id 对象ID
     * @return wowoCartItem对象
     */
    WowoCartItem findCartItemById(Integer id);

    /**
     * 清空购物车里的指定项目
     * @param wowoCartItems 待清空的项目
     */
    void clearCartItem(List<WowoCartItem> wowoCartItems);

    /**
     *  添加 商品到购物车 /add
     *  @param wowoCartItems 待添加的购物车项目
     */
    void addCartItem(WowoCartItem wowoCartItems);



}
