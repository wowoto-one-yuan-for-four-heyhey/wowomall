package com.xmu.wowoto.wowomall.domain.po;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:团购规则信息
 * @Data:Created in 14:50 2019/12/11
 **/
public class GrouponRulePo {
    private Integer id;
    /**
     * 团购开始时间
     */
    private LocalDateTime startTime;
    /**
     * 团购结束时间
     */
    private LocalDateTime endTime;
    /**
     * 判断团购是否还在进行中
     */
    private Boolean statusCode;
    /**
     * 团购等级（满多少人组团多少折扣）
     * JSON格式: {"strategy": [{"lowerbound":xxx, "upperbound":xxx, "rate":xxx}]}, xxx为具体数值
     */
    private String grouponLevelStragety;
    /**
     * 团购商品id
     */
    private Integer goodsId;

    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public Boolean getStatusCode() {
        return this.statusCode;
    }

    public String getGrouponLevelStragety() {
        return this.grouponLevelStragety;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public LocalDateTime getGmtCreate() {
        return this.gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return this.gmtModified;
    }

    public Boolean getBeDeleted() {
        return this.beDeleted;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setStatusCode(Boolean statusCode) {
        this.statusCode = statusCode;
    }

    public void setGrouponLevelStragety(String grouponLevelStragety) {
        this.grouponLevelStragety = grouponLevelStragety;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public void setBeDeleted(Boolean beDeleted) {
        this.beDeleted = beDeleted;
    }

    @Override
    public boolean equals(final Object o) {

        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GrouponRulePo;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "GrouponRulePo(id=" + this.getId() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", statusCode=" + this.getStatusCode() + ", grouponLevelStragety=" + this.getGrouponLevelStragety() + ", goodsId=" + this.getGoodsId() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}