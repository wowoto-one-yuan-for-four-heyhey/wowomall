package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.domain.WowoCartItem;
import com.xmu.wowoto.wowomall.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Service
public class CartServiceImpl implements CartService {
    @Override
    public WowoCartItem findCartItemById(Integer id) {
        return null;
    }

    @Override
    public void clearCartItem(List<WowoCartItem> wowoCartItems) {

    }

    @Override
    public void addCartItem(WowoCartItem wowoCartItems){

    }
}
