package com.xmu.wowoto.wowomall.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xmu.wowoto.wowomall.entity.OrderItem;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Alias("WowoOrderItem")
@JsonSerialize(as = OrderItem.class)
public class WowoOrderItem extends com.xmu.wowoto.wowomall.entity.OrderItem {

    WowoProduct wowoProduct;
    public WowoOrderItem(){
    }
    public WowoOrderItem(WowoCartItem wowoCartItem){
        this.setNumber(wowoCartItem.getNumber());
        WowoProduct wowoProduct = wowoCartItem.getWowoProduct();
        this.setWowoProduct(wowoProduct);
        this.setProductId(wowoProduct.getId());
        this.setPrice(wowoProduct.getPrice());
        this.setDealPrice(this.getPrice());
        this.setGmtCreate(LocalDateTime.now());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        WowoOrderItem newItem = (WowoOrderItem) super.clone();
        newItem.setId(null);
        newItem.setGmtCreate(LocalDateTime.now());
        newItem.setGmtModified(null);
        return newItem;
    }

    public WowoProduct getWowoProduct() {
        return wowoProduct;
    }

    public void setWowoProduct(WowoProduct wowoProduct) {
        this.wowoProduct = wowoProduct;
    }
}
