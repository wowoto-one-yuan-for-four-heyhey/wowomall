package com.xmu.wowoto.wowomall.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xmu.wowoto.wowomall.entity.Product;

@JsonSerialize(as = Product.class)
public class WowoProduct extends Product {

    WowoGoods wowoGoods;

    public WowoGoods getWowoGoods() {
        return wowoGoods;
    }

    public void setWowoGoods(WowoGoods wowoGoods) {
        this.wowoGoods = wowoGoods;
    }
}
