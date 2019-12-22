package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.domain.Po.CartItemPo;

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

    public boolean equals(final Object o) {
        if (o == this){ return true;}
        if (!(o instanceof CartItem)){ return false;}
        final CartItem other = (CartItem) o;
        if (!other.canEqual((Object) this)){ return false;}
        if (!super.equals(o)) {return false;}
        final Object this$product = this.getProduct();
        final Object other$product = other.getProduct();
        if (this$product == null ? other$product != null : !this$product.equals(other$product)) {return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CartItem;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $product = this.getProduct();
        result = result * PRIME + ($product == null ? 43 : $product.hashCode());
        return result;
    }

    public String toString() {
        return "CartItem(product=" + this.getProduct() + ")";
    }
}
