package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.domain.CartItem;
import com.xmu.wowoto.wowomall.service.CartService;
import com.xmu.wowoto.wowomall.service.RemoteCartService;
import com.xmu.wowoto.wowomall.util.JacksonUtil;
import com.xmu.wowoto.wowomall.util.ResponseUtil;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/14 20:13
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    RemoteCartService remoteCartService;

    /**
     * 用ID获得CartItem对象
     * @param id 对象ID
     * @return CartItem
     */
    @Override
    public CartItem findCartItemById(Integer id){
        String json = remoteCartService.findCartItemById(id);
        if(!JacksonUtil.parseInteger(json, "errno").equals(200))
            return null;
        return JacksonUtil.parseObject(json, "data", CartItem.class);
    }

    /**
     * 清空购物车里的指定项目
     * @param cartItems 待清空的项目
     */
    @Override
    public boolean clearCartItem(List<CartItem> cartItems){
        String json = remoteCartService.clearCartItem(cartItems);
        return JacksonUtil.parseInteger(json, "errno").equals(200);
    }

    @Override
    public boolean deleteCartItem(Integer cartItemId) {
        String json = remoteCartService.deleteCartItem(cartItemId);
        return JacksonUtil.parseInteger(json, "errno").equals(200);
    }
}
