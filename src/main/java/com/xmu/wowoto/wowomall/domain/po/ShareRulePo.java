package com.xmu.wowoto.wowomall.domain.po;

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

        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ShareRulePo;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "ShareRulePo(id=" + this.getId() + ", shareLevelStrategy=" + this.getShareLevelStrategy() + ", goodsId=" + this.getGoodsId() + ", beDeleted=" + this.getBeDeleted() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ")";
    }
}
