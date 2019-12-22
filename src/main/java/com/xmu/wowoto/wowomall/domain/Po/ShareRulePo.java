package com.xmu.wowoto.wowomall.domain.Po;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description: 分享规则
 * @Date: Created in 16:00 2019/12/11
 **/
public class ShareRulePo {
    private Integer id;
    /**
    * 分享等级（分享次数所对应返利）
     * JSON格式: {"strategy": [{"lowerbound":xxx, "upperbound":xxx, "rate":xxx}], "type": xxx}, xxx为具体数值
     * type = 0表示单返给最早的用户，type = 1表示平均返
    */
    private String shareLevelStrategy;
    /**
    *商品ID
    */
    private Integer goodsId;

    private Boolean beDeleted;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;

    public Integer getId() {
        return this.id;
    }

    public String getShareLevelStrategy() {
        return this.shareLevelStrategy;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public Boolean getBeDeleted() {
        return this.beDeleted;
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

    public void setShareLevelStrategy(String shareLevelStrategy) {
        this.shareLevelStrategy = shareLevelStrategy;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setBeDeleted(Boolean beDeleted) {
        this.beDeleted = beDeleted;
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
        if (!(o instanceof ShareRulePo)) {return false;}
        final ShareRulePo other = (ShareRulePo) o;
        if (!other.canEqual((Object) this)){return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {return false;}
        final Object this$shareLevelStrategy = this.getShareLevelStrategy();
        final Object other$shareLevelStrategy = other.getShareLevelStrategy();
        if (this$shareLevelStrategy == null ? other$shareLevelStrategy != null : !this$shareLevelStrategy.equals(other$shareLevelStrategy))
        {return false;}
        final Object this$goodsId = this.getGoodsId();
        final Object other$goodsId = other.getGoodsId();
        if (this$goodsId == null ? other$goodsId != null : !this$goodsId.equals(other$goodsId)) {return false;}
        final Object this$beDeleted = this.getBeDeleted();
        final Object other$beDeleted = other.getBeDeleted();
        if (this$beDeleted == null ? other$beDeleted != null : !this$beDeleted.equals(other$beDeleted)) {return false;}
        final Object this$gmtCreate = this.getGmtCreate();
        final Object other$gmtCreate = other.getGmtCreate();
        if (this$gmtCreate == null ? other$gmtCreate != null : !this$gmtCreate.equals(other$gmtCreate)) {return false;}
        final Object this$gmtModified = this.getGmtModified();
        final Object other$gmtModified = other.getGmtModified();
        if (this$gmtModified == null ? other$gmtModified != null : !this$gmtModified.equals(other$gmtModified))
        {return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ShareRulePo;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $shareLevelStrategy = this.getShareLevelStrategy();
        result = result * PRIME + ($shareLevelStrategy == null ? 43 : $shareLevelStrategy.hashCode());
        final Object $goodsId = this.getGoodsId();
        result = result * PRIME + ($goodsId == null ? 43 : $goodsId.hashCode());
        final Object $beDeleted = this.getBeDeleted();
        result = result * PRIME + ($beDeleted == null ? 43 : $beDeleted.hashCode());
        final Object $gmtCreate = this.getGmtCreate();
        result = result * PRIME + ($gmtCreate == null ? 43 : $gmtCreate.hashCode());
        final Object $gmtModified = this.getGmtModified();
        result = result * PRIME + ($gmtModified == null ? 43 : $gmtModified.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ShareRulePo(id=" + this.getId() + ", shareLevelStrategy=" + this.getShareLevelStrategy() + ", goodsId=" + this.getGoodsId() + ", beDeleted=" + this.getBeDeleted() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ")";
    }
}
