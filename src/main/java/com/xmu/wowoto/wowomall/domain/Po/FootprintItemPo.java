package com.xmu.wowoto.wowomall.domain.Po;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:足迹信息
 * @Data:Created in 14:50 2019/12/11
 **/
public class FootprintItemPo {
    private Integer id;

    /**
    *创建时间
    */
    private LocalDateTime birthTime;
    /**
    *用户id
    */
    private Integer userId;
    /**
    *商品id
    */
    private Integer goodsId;
    private LocalDateTime gmtCreate;

    public Integer getId() {
        return this.id;
    }

    public LocalDateTime getBirthTime() {
        return this.birthTime;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public LocalDateTime getGmtCreate() {
        return this.gmtCreate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBirthTime(LocalDateTime birthTime) {
        this.birthTime = birthTime;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof FootprintItemPo)) return false;
        final FootprintItemPo other = (FootprintItemPo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$birthTime = this.getBirthTime();
        final Object other$birthTime = other.getBirthTime();
        if (this$birthTime == null ? other$birthTime != null : !this$birthTime.equals(other$birthTime)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$goodsId = this.getGoodsId();
        final Object other$goodsId = other.getGoodsId();
        if (this$goodsId == null ? other$goodsId != null : !this$goodsId.equals(other$goodsId)) return false;
        final Object this$gmtCreate = this.getGmtCreate();
        final Object other$gmtCreate = other.getGmtCreate();
        if (this$gmtCreate == null ? other$gmtCreate != null : !this$gmtCreate.equals(other$gmtCreate)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FootprintItemPo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $birthTime = this.getBirthTime();
        result = result * PRIME + ($birthTime == null ? 43 : $birthTime.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $goodsId = this.getGoodsId();
        result = result * PRIME + ($goodsId == null ? 43 : $goodsId.hashCode());
        final Object $gmtCreate = this.getGmtCreate();
        result = result * PRIME + ($gmtCreate == null ? 43 : $gmtCreate.hashCode());
        return result;
    }

    public String toString() {
        return "FootprintItemPo(id=" + this.getId() + ", birthTime=" + this.getBirthTime() + ", userId=" + this.getUserId() + ", goodsId=" + this.getGoodsId() + ", gmtCreate=" + this.getGmtCreate() + ")";
    }
}
