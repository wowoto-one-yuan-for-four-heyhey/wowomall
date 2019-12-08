package com.xmu.wowoto.wowomall.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author wowoto
 * @date 12/07/2019
 */
public abstract class AbstractCouponStrategy {
    private Logger logger = LoggerFactory.getLogger(AbstractCouponStrategy.class);

    /**
     * 用于判断是否已经满足优惠门槛
     * @param totalPrice 总费用
     * @param totalQuantity 总数量
     * @return true- 已经满足， false - 不满足
     */
    protected abstract boolean isEnough(BigDecimal totalPrice, Integer totalQuantity);

    /**
     * 计算折扣后的价格
     * @param totalPrice 优惠货品的总价
     * @param  itemPrice 当前货品的小计价格
     * @return 折扣后的价格
     */
    protected abstract BigDecimal getDealPrice(BigDecimal itemPrice, BigDecimal totalPrice);

    /**
     * 获得优惠金额与设定的误差
     * @param totalPrice 订单原价
     * @param dealPrice 优惠价
     * @return 误差值
     */
    protected abstract BigDecimal getError(BigDecimal totalPrice, BigDecimal dealPrice);

    /**
     * 获得优惠的费用
     * @param validItems 订单中可以用于优惠卷的明细
     * @param couponSn 优惠卷序号
     * @return 更新的订单列表，包含可能因为误差拆开的明细
     */
    public List<WowoOrderItem> cacuDiscount(List<WowoOrderItem> validItems, String couponSn){
        //优惠商品的总价和数量
        BigDecimal totalPrice = BigDecimal.ZERO;
        Integer totalQuantity = 0;

        //优惠的货品
        List<WowoOrderItem> discountItems = new ArrayList<>(validItems.size());

        Iterator<WowoOrderItem> itemIterator = validItems.iterator();

        while (itemIterator.hasNext()){
            WowoOrderItem item = itemIterator.next();
            totalPrice = totalPrice.add(item.getPrice().multiply(BigDecimal.valueOf(item.getNumber())));
            totalQuantity += item.getNumber();
            discountItems.add(item);
        }

        //判断是否达到优惠门槛
        boolean enough = this.isEnough(totalPrice, totalQuantity);

        //计算优惠后的价格
        List<WowoOrderItem> newItems = new ArrayList<>();
        BigDecimal dealTotalPrice = BigDecimal.ZERO;
        if (enough) {
            for (WowoOrderItem item: discountItems){
                //按照比例分配，可能会出现精度误差，在后面补偿到第一个货品上
                BigDecimal dealPrice = this.getDealPrice(item.getPrice(), totalPrice);
                item.setDealPrice(dealPrice);
                dealTotalPrice = dealTotalPrice.add(dealPrice.multiply(BigDecimal.valueOf(item.getNumber())));
            }

            BigDecimal error = this.getError(totalPrice, dealTotalPrice);
            if (error.compareTo(BigDecimal.ZERO) != 0){
                //前面保留小数两位数可能出现的精度误差
                //寻找数量为1的明细，将误差补偿在此明细上，否则拆开一个现有明细

                Boolean gotIt = false;
                for (WowoOrderItem item : validItems){
                    if (item.getNumber() == 1){
                        BigDecimal dealPrice = item.getDealPrice();
                        item.setDealPrice(dealPrice.add(error));
                        gotIt = true;
                        break;
                    }
                }

                if (!gotIt){
                    //无数量为1的明细，拆第一个
                    WowoOrderItem item = validItems.get(0);
                    Integer quantity = item.getNumber();
                    item.setNumber(quantity - 1);
                    try {
                        WowoOrderItem newItem = (WowoOrderItem) item.clone();
                        newItem.setNumber(1);
                        BigDecimal dealPrice = newItem.getDealPrice();
                        newItem.setDealPrice(dealPrice.add(error));
                        newItems.add(newItem);
                    } catch (CloneNotSupportedException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }
        }

        logger.debug("cacuDiscount返回 newItems = "+newItems);
        return newItems;
    }
}
