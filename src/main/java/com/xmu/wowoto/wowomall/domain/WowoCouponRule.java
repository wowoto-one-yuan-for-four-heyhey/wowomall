package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.entity.CouponRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
public class WowoCouponRule {
    private static final Logger logger = LoggerFactory.getLogger(CouponRule.class);

    private CouponRule realObj;

    /**
     * 判断商品是否能用于这张优惠卷
     *
     * @param goodsId 商品的id
     * @return
     */
    public boolean isUsedOnGoods(Integer goodsId) {
        Set<Integer> goodsIds = new TreeSet<>();
        goodsIds.clear();

        for (String id: realObj.getGoodsList1().split(","))
        {   goodsIds.add(Integer.parseInt(id));}
        for (String id: realObj.getGoodsList2().split(","))
        {    goodsIds.add(Integer.parseInt(id));}

        return goodsIds.contains(goodsId);
    }

    /**
     * 获得能用于此优惠卷的明细
     * @param items 订单明细
     * @return 适用的订单明细
     */
    private List<WowoOrderItem> getValidItems(List<WowoOrderItem> items){
        List<WowoOrderItem> validItems = new ArrayList<>(items.size());
        for (WowoOrderItem item: items){
            WowoGoods wowoGoods = item.getWowoProduct().getWowoGoods();
            if (this.isUsedOnGoods(wowoGoods.getId())){
                validItems.add(item);
            }
        }
        return validItems;

    }

    /**
     * 获得折扣策略
     * JSON格式:{ name：“XXX”, obj:{XXX}}
     * @return 折扣策略对象
     */
    public AbstractCouponStrategy getStrategy() {
        AbstractCouponStrategy strategy = null;
        try {
            strategy = (AbstractCouponStrategy)Class.forName("strategy").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return strategy;
    }

    /**
     * 获得优惠的费用
     * @param order 订单
     * @param couponSn 优惠卷号
     * @return
     */
    public void cacuCouponPrice(WowoOrder order, String couponSn){

        List<WowoOrderItem> validItems = this.getValidItems(order.getWowoOrderItems());

        if (validItems.size() != 0) {
            List<WowoOrderItem> newItems = this.getStrategy().cacuDiscount(validItems, couponSn);
            order.getWowoOrderItems().addAll(newItems);
        }
        logger.debug("cacuCouponPrice返回");
    }
}