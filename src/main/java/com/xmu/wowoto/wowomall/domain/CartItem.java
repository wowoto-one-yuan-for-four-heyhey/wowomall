package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.domain.po.CartItemPo;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:购物车明细对象
 * @Data:Created in 14:50 2019/12/11
 **/
public class CartItem extends CartItemPo {

    private Product product;

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this){ return true;}
        if (!(o instanceof CartItem)){ return false;}
        final CartItem other = (CartItem) o;
        if (!other.canEqual((Object) this)){ return false;}
        if (!super.equals(o)) {return false;}
        final Object thisProduct = this.getProduct();
        final Object otherProduct = other.getProduct();
        if (thisProduct == null ? otherProduct != null : !thisProduct.equals(otherProduct)) {return false;}
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof CartItem;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "CartItem(product=" + this.getProduct() + ")";
    }
}
