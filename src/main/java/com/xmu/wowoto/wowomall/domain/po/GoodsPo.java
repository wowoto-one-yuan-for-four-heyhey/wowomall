package com.xmu.wowoto.wowomall.domain.po;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:商品信息
 * @Data:Created in 14:50 2019/12/11
 **/
public class GoodsPo {

    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品序列号
     */
     private String goodsSn;
    /**
     * 商品简称
     */
    private String shortName;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 商品简介
     */
    private String brief;
    /**
     * 图片链接
     */
    private String picUrl;
    /**
     * 商品详情（可以参照淘宝的商品详情页，全是图片的那种）
     * JSON格式: {"detail": [xxx,xxx,xxx]},xxx代表图片url
     */
    private String detail;
    /**
     * 上下架状态，0表示下架，1表示上架，2表示最新，3表示最热，4表示最新且最热
     */
    private Integer statusCode;
    /**
     * 分享链接
     */
    private String shareUrl;
    /**
     * 商品图片展示廊，就是像淘宝点进商品，滚动展示很多图片
     * JSON格式: {"gallery": [xxx,xxx,xxx] },xxx代表图片url
     */
    private String gallery;
    /**
     * 商品分类ID
     */
    private Integer goodsCategoryId;
    /**
     * 品牌ID
     */
    private Integer brandId;
    /**
     * 商品重量
     */
    private BigDecimal weight;
    /**
     * 商品体积
     * JSON格式: {length:xxx, width:xxx, height:xxx},xxx为具体数值,单位厘米
     */
    private String volume;
    /**
     * 特殊邮费计算模板ID
     */
    private Integer specialFreightId;
    /**
     * 0：默认模板计算邮费 1：特殊模板计算邮费
     */
    private Boolean beSpecial;
    /**
     * 该商品的最低产品价格
     */
    private BigDecimal price;

    private Boolean beDeleted;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getGoodsSn() {
        return this.goodsSn;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getBrief() {
        return this.brief;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getDetail() {
        return this.detail;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String getGallery() {
        return this.gallery;
    }

    public Integer getGoodsCategoryId() {
        return this.goodsCategoryId;
    }

    public Integer getBrandId() {
        return this.brandId;
    }

    public BigDecimal getWeight() {
        return this.weight;
    }

    public String getVolume() {
        return this.volume;
    }

    public Integer getSpecialFreightId() {
        return this.specialFreightId;
    }

    public Boolean getBeSpecial() {
        return this.beSpecial;
    }

    public BigDecimal getPrice() {
        return this.price;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public void setGoodsCategoryId(Integer goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setSpecialFreightId(Integer specialFreightId) {
        this.specialFreightId = specialFreightId;
    }

    public void setBeSpecial(Boolean beSpecial) {
        this.beSpecial = beSpecial;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        return other instanceof GoodsPo;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "GoodsPo(id=" + this.getId() + ", name=" + this.getName() + ", goodsSn=" + this.getGoodsSn() + ", shortName=" + this.getShortName() + ", description=" + this.getDescription() + ", brief=" + this.getBrief() + ", picUrl=" + this.getPicUrl() + ", detail=" + this.getDetail() + ", statusCode=" + this.getStatusCode() + ", shareUrl=" + this.getShareUrl() + ", gallery=" + this.getGallery() + ", goodsCategoryId=" + this.getGoodsCategoryId() + ", brandId=" + this.getBrandId() + ", weight=" + this.getWeight() + ", volume=" + this.getVolume() + ", specialFreightId=" + this.getSpecialFreightId() + ", beSpecial=" + this.getBeSpecial() + ", price=" + this.getPrice() + ", beDeleted=" + this.getBeDeleted() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ")";
    }
}
