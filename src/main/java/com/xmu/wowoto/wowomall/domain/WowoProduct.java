package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.entity.Product;

public class WowoProduct extends Product {

    WowoGoods wowoGoods;

    public WowoGoods getWowoGoods() {
        return wowoGoods;
    }

    public void setWowoGoods(WowoGoods wowoGoods) {
        this.wowoGoods = wowoGoods;
    }
}
