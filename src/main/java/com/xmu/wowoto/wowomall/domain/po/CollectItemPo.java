package com.xmu.wowoto.wowomall.domain.po;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:收藏明细
 * @Data:Created in 14:50 2019/12/11
 **/
public class CollectItemPo {
    private Integer id;
    /**
    *商品id
    */
    private Integer goodsId;
    /**
    *用户id
    */
    private Integer userId;

    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;

    public Integer getId() {
        return this.id;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public LocalDateTime getGmtCreate() {
        return this.gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return this.gmtModified;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {return true;}
        if (!(o instanceof CollectItemPo)) {return false;}
        final CollectItemPo other = (CollectItemPo) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object thisid = this.getId();
        final Object otherid = other.getId();
        if (thisid == null ? otherid != null : !thisid.equals(otherid)){ return false;}
        final Object thisgoodsId = this.getGoodsId();
        final Object othergoodsId = other.getGoodsId();
        if (thisgoodsId == null ? othergoodsId != null : !thisgoodsId.equals(othergoodsId)){ return false;}
        final Object thisuserId = this.getUserId();
        final Object otheruserId = other.getUserId();
        if (thisuserId == null ? otheruserId != null : !thisuserId.equals(otheruserId)){ return false;}
        final Object thisgmtCreate = this.getGmtCreate();
        final Object othergmtCreate = other.getGmtCreate();
        if (thisgmtCreate == null ? othergmtCreate != null : !thisgmtCreate.equals(othergmtCreate)) {return false;}
        final Object thisgmtModified = this.getGmtModified();
        final Object othergmtModified = other.getGmtModified();
        if (thisgmtModified == null ? othergmtModified != null : !thisgmtModified.equals(othergmtModified))
        { return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CollectItemPo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        final Object id = this.getId();
        result = result * prime + (id == null ? 43 : id.hashCode());
        final Object goodsId = this.getGoodsId();
        result = result * prime + (goodsId == null ? 43 : goodsId.hashCode());
        final Object userId = this.getUserId();
        result = result * prime + (userId == null ? 43 : userId.hashCode());
        final Object gmtCreate = this.getGmtCreate();
        result = result * prime + (gmtCreate == null ? 43 : gmtCreate.hashCode());
        final Object gmtModified = this.getGmtModified();
        result = result * prime + (gmtModified == null ? 43 : gmtModified.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CollectItemPo(id=" + this.getId() + ", goodsId=" + this.getGoodsId() + ", userId=" + this.getUserId() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ")";
    }
}
