package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.CartItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 * @author wowoto
 * @date 12/08/2019
 */

@Service
@FeignClient("wowoto-cart")
public interface CartService {
    @GetMapping(value = "/carts")
    Object cartIndex(@RequestParam(value = "userId") Integer userId);

    /**
     * 用ID获得CartItem对象
     * @param id 对象ID
     * @return wowoCartItem对象
     */
    @GetMapping(value = "")
    CartItem findCartItemById(Integer id);

    /**
     * 清空购物车里的指定项目
     * @param wowoCartItems 待清空的项目
     */
    @PostMapping(value = "")
    void clearCartItem(List<CartItem> wowoCartItems);

    /**
     *  添加 商品到购物车 /add
     *  @param wowoCartItems 待添加的购物车项目
     */
    @PostMapping(value = "")
    void addCartItem(CartItem wowoCartItems);

}
