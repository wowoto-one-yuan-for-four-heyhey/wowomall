package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.CartItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/14 20:09
 */
@Service
@FeignClient("cartService")
public interface RemoteCartService {
    /**
     * 用ID获得CartItem对象
     * @param id 对象ID
     * @return CartItem
     */
    @GetMapping(value = "cartItems/{id}")
    String findCartItemById(@PathVariable("id") Integer id);

    /**
     * 清空购物车里的指定项目
     * @param cartItems 待清空的项目
     */
    @PostMapping(value = "cartItems")
    String clearCartItem(@RequestBody List<CartItem> cartItems);
}
