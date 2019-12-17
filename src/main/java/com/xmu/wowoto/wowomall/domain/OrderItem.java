package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.domain.Po.OrderItemPo;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:订单明细对象
 * @Data:Created in 14:50 2019/12/11
 **/
public class OrderItem extends OrderItemPo {
    private Product product;

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        OrderItem newItem = (OrderItem) super.clone();
        newItem.setId(null);
        return newItem;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OrderItem)) return false;
        final OrderItem other = (OrderItem) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        final Object this$product = this.getProduct();
        final Object other$product = other.getProduct();
        if (this$product == null ? other$product != null : !this$product.equals(other$product)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderItem;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $product = this.getProduct();
        result = result * PRIME + ($product == null ? 43 : $product.hashCode());
        return result;
    }

    public String toString() {
        return "OrderItem(product=" + this.getProduct() + ")";
    }

    public enum StatusCode{
        NOT_PAYED(0),
        NOT_SHIPPED(1),
        NOT_CONFIRMED(2),
        CONFIRMED(3),
        FINISHED(4),
        APPLY_RETURN(5),
        RETURN_SUCCESS(6),
        APPLY_EXCHANGE(7),
        EXCHANGE_SUCCESS(8),
        PRESALE(9);

        private final int value;

        StatusCode(int value) { this.value = value; }

        public int getValue() { return value; }
    }
    public OrderItem(){
        super();
    }

    public OrderItem(CartItem cartItem){
        this.setNumber(cartItem.getNumber());
        Product product = cartItem.getProduct();
        this.setProduct(product);
        this.setProductId(product.getId());
        this.setPrice(product.getPrice());
        this.setDealPrice(this.getPrice());
    }
}
