package com.xmu.wowoto.wowomall.domain.po;

import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:评论
 * @Data:Created in 14:50 2019/12/11
 **/
public class CommentPo {
    private Integer id;
    /**
     * 发表评论的用户的id
     */
    private Integer userId;
    /**
     * 发表评论的内容
     */
    private String content;
    /**
     * 评论的状态 0：未审核 1：审核通过 2：审核失败
     */
    private Integer statusCode;
    /**
     * 发表评论的星级（1-5）
     */
    private Integer star;
    /**
     * 评论的产品的id
     */
    private Integer productId;

    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public String getContent() {
        return this.content;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public Integer getStar() {
        return this.star;
    }

    public Integer getProductId() {
        return this.productId;
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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
        if (o == this) {return true;}
        if (!(o instanceof CommentPo)) {return false;}
        final CommentPo other = (CommentPo) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object thisId = this.getId();
        final Object otherId = other.getId();
        if (thisId == null ? otherId != null : !thisId.equals(otherId)) {return false;}
        final Object thisUserId = this.getUserId();
        final Object otherUserId = other.getUserId();
        if (thisUserId == null ? otherUserId != null : !thisUserId.equals(otherUserId)) {return false;}
        final Object thisContent = this.getContent();
        final Object otherContent = other.getContent();
        if (thisContent == null ? otherContent != null : !thisContent.equals(otherContent)){ return false;}
        final Object thisStatusCode = this.getStatusCode();
        final Object otherStatusCode = other.getStatusCode();
        if (thisStatusCode == null ? otherStatusCode != null : !thisStatusCode.equals(otherStatusCode))
        {    return false;}
        final Object thisStar = this.getStar();
        final Object otherStar = other.getStar();
        if (thisStar == null ? otherStar != null : !thisStar.equals( otherStar)) {return false;}
        final Object thisProductId = this.getProductId();
        final Object otherProductId = other.getProductId();
        if (thisProductId == null ? otherProductId != null : !thisProductId.equals(otherProductId)) {return false;}
        final Object thisGmtCreate = this.getGmtCreate();
        final Object otherGmtCreate = other.getGmtCreate();
        if (thisGmtCreate == null ? otherGmtCreate != null : !thisGmtCreate.equals(otherGmtCreate)) {return false;}
        final Object thisGmtModified = this.getGmtModified();
        final Object otherGmtModified = other.getGmtModified();
        if (thisGmtModified == null ? otherGmtModified != null : !thisGmtModified.equals(otherGmtModified))
        {    return false;}
        final Object thisBeDeleted = this.getBeDeleted();
        final Object otherBeDeleted = other.getBeDeleted();
        if (thisBeDeleted == null ? otherBeDeleted != null : !thisBeDeleted.equals(otherBeDeleted)) {return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommentPo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        final Object id = this.getId();
        result = result * prime + (id == null ? 43 : id.hashCode());
        final Object userId = this.getUserId();
        result = result * prime + (userId == null ? 43 : userId.hashCode());
        final Object content = this.getContent();
        result = result * prime + (content == null ? 43 : content.hashCode());
        final Object statusCode = this.getStatusCode();
        result = result * prime + (statusCode == null ? 43 : statusCode.hashCode());
        final Object star = this.getStar();
        result = result * prime + (star == null ? 43 : star.hashCode());
        final Object productId = this.getProductId();
        result = result * prime + (productId == null ? 43 : productId.hashCode());
        final Object gmtCreate = this.getGmtCreate();
        result = result * prime + (gmtCreate == null ? 43 : gmtCreate.hashCode());
        final Object gmtModified = this.getGmtModified();
        result = result * prime + (gmtModified == null ? 43 : gmtModified.hashCode());
        final Object beDeleted = this.getBeDeleted();
        result = result * prime + (beDeleted == null ? 43 : beDeleted.hashCode());
        return result;
    }
    @Override
    public String toString() {
        return "CommentPo(id=" + this.getId() + ", userId=" + this.getUserId() + ", content=" + this.getContent() + ", statusCode=" + this.getStatusCode() + ", star=" + this.getStar() + ", productId=" + this.getProductId() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
