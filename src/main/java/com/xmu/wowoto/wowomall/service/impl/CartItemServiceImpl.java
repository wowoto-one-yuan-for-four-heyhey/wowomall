package com.xmu.wowoto.wowomall.service.impl;

import com.xmu.wowoto.wowomall.domain.WowoCartItem;
import com.xmu.wowoto.wowomall.service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Override
    public WowoCartItem findCartItemById(Integer id) {
        return null;
    }

    @Override
    public void clearCartItem(List<WowoCartItem> wowoCartItems) {

    }
}
