package com.xmu.wowoto.wowomall.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xmu.wowoto.wowomall.entity.CartItem;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@JsonSerialize(as = CartItem.class)
public class WowoCartItem extends CartItem {

    private WowoProduct wowoProduct;

    public WowoProduct getWowoProduct() {
        return wowoProduct;
    }

    public void setWowoProduct(WowoProduct wowoProduct) {
        this.wowoProduct = wowoProduct;
    }
}
