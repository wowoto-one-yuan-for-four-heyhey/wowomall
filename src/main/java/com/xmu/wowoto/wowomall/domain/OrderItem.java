package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.domain.Po.OrderItemPo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:订单明细对象
 * @Data:Created in 14:50 2019/12/11
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class OrderItem extends OrderItemPo {
    private Product product;

    public enum StatusCode{
        NOT_PAYED(0),
        NOT_SHIPPED(1),
        NOT_CONFIRMED(2),
        NOT_COMMENT(3),
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

    public OrderItem(CartItem cartItem){
        this.setNumber(cartItem.getNumber());
        Product product = cartItem.getProduct();
        this.setProduct(product);
        this.setProductId(product.getId());
        this.setPrice(product.getPrice());
        this.setDealPrice(this.getPrice());
    }
}
