package com.xmu.wowoto.wowomall.domain.Po;

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
        if (o == this) {return true;}
        if (!(o instanceof GoodsPo)) {return false;}
        final GoodsPo other = (GoodsPo) o;
        if (!other.canEqual((Object) this)) {return false;}
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {return false;}
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {return false;}
        final Object this$goodsSn = this.getGoodsSn();
        final Object other$goodsSn = other.getGoodsSn();
        if (this$goodsSn == null ? other$goodsSn != null : !this$goodsSn.equals(other$goodsSn)) {return false;}
        final Object this$shortName = this.getShortName();
        final Object other$shortName = other.getShortName();
        if (this$shortName == null ? other$shortName != null : !this$shortName.equals(other$shortName)) {return false;}
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
        { return false;}
        final Object this$brief = this.getBrief();
        final Object other$brief = other.getBrief();
        if (this$brief == null ? other$brief != null : !this$brief.equals(other$brief)){ return false;}
        final Object this$picUrl = this.getPicUrl();
        final Object other$picUrl = other.getPicUrl();
        if (this$picUrl == null ? other$picUrl != null : !this$picUrl.equals(other$picUrl)) {return false;}
        final Object this$detail = this.getDetail();
        final Object other$detail = other.getDetail();
        if (this$detail == null ? other$detail != null : !this$detail.equals(other$detail)) {return false;}
        final Object this$statusCode = this.getStatusCode();
        final Object other$statusCode = other.getStatusCode();
        if (this$statusCode == null ? other$statusCode != null : !this$statusCode.equals(other$statusCode))
        {  return false;}
        final Object this$shareUrl = this.getShareUrl();
        final Object other$shareUrl = other.getShareUrl();
        if (this$shareUrl == null ? other$shareUrl != null : !this$shareUrl.equals(other$shareUrl)){ return false;}
        final Object this$gallery = this.getGallery();
        final Object other$gallery = other.getGallery();
        if (this$gallery == null ? other$gallery != null : !this$gallery.equals(other$gallery)) {return false;}
        final Object this$goodsCategoryId = this.getGoodsCategoryId();
        final Object other$goodsCategoryId = other.getGoodsCategoryId();
        if (this$goodsCategoryId == null ? other$goodsCategoryId != null : !this$goodsCategoryId.equals(other$goodsCategoryId))
        {   return false;}
        final Object this$brandId = this.getBrandId();
        final Object other$brandId = other.getBrandId();
        if (this$brandId == null ? other$brandId != null : !this$brandId.equals(other$brandId)) {return false;}
        final Object this$weight = this.getWeight();
        final Object other$weight = other.getWeight();
        if (this$weight == null ? other$weight != null : !this$weight.equals(other$weight)) {return false;}
        final Object this$volume = this.getVolume();
        final Object other$volume = other.getVolume();
        if (this$volume == null ? other$volume != null : !this$volume.equals(other$volume)) {return false;}
        final Object this$specialFreightId = this.getSpecialFreightId();
        final Object other$specialFreightId = other.getSpecialFreightId();
        if (this$specialFreightId == null ? other$specialFreightId != null : !this$specialFreightId.equals(other$specialFreightId))
        {   return false;}
        final Object this$beSpecial = this.getBeSpecial();
        final Object other$beSpecial = other.getBeSpecial();
        if (this$beSpecial == null ? other$beSpecial != null : !this$beSpecial.equals(other$beSpecial)) {return false;}
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)){ return false;}
        final Object this$beDeleted = this.getBeDeleted();
        final Object other$beDeleted = other.getBeDeleted();
        if (this$beDeleted == null ? other$beDeleted != null : !this$beDeleted.equals(other$beDeleted)) {return false;}
        final Object this$gmtCreate = this.getGmtCreate();
        final Object other$gmtCreate = other.getGmtCreate();
        if (this$gmtCreate == null ? other$gmtCreate != null : !this$gmtCreate.equals(other$gmtCreate)){ return false;}
        final Object this$gmtModified = this.getGmtModified();
        final Object other$gmtModified = other.getGmtModified();
        if (this$gmtModified == null ? other$gmtModified != null : !this$gmtModified.equals(other$gmtModified))
        {   return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GoodsPo;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $goodsSn = this.getGoodsSn();
        result = result * PRIME + ($goodsSn == null ? 43 : $goodsSn.hashCode());
        final Object $shortName = this.getShortName();
        result = result * PRIME + ($shortName == null ? 43 : $shortName.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $brief = this.getBrief();
        result = result * PRIME + ($brief == null ? 43 : $brief.hashCode());
        final Object $picUrl = this.getPicUrl();
        result = result * PRIME + ($picUrl == null ? 43 : $picUrl.hashCode());
        final Object $detail = this.getDetail();
        result = result * PRIME + ($detail == null ? 43 : $detail.hashCode());
        final Object $statusCode = this.getStatusCode();
        result = result * PRIME + ($statusCode == null ? 43 : $statusCode.hashCode());
        final Object $shareUrl = this.getShareUrl();
        result = result * PRIME + ($shareUrl == null ? 43 : $shareUrl.hashCode());
        final Object $gallery = this.getGallery();
        result = result * PRIME + ($gallery == null ? 43 : $gallery.hashCode());
        final Object $goodsCategoryId = this.getGoodsCategoryId();
        result = result * PRIME + ($goodsCategoryId == null ? 43 : $goodsCategoryId.hashCode());
        final Object $brandId = this.getBrandId();
        result = result * PRIME + ($brandId == null ? 43 : $brandId.hashCode());
        final Object $weight = this.getWeight();
        result = result * PRIME + ($weight == null ? 43 : $weight.hashCode());
        final Object $volume = this.getVolume();
        result = result * PRIME + ($volume == null ? 43 : $volume.hashCode());
        final Object $specialFreightId = this.getSpecialFreightId();
        result = result * PRIME + ($specialFreightId == null ? 43 : $specialFreightId.hashCode());
        final Object $beSpecial = this.getBeSpecial();
        result = result * PRIME + ($beSpecial == null ? 43 : $beSpecial.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
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
        return "GoodsPo(id=" + this.getId() + ", name=" + this.getName() + ", goodsSn=" + this.getGoodsSn() + ", shortName=" + this.getShortName() + ", description=" + this.getDescription() + ", brief=" + this.getBrief() + ", picUrl=" + this.getPicUrl() + ", detail=" + this.getDetail() + ", statusCode=" + this.getStatusCode() + ", shareUrl=" + this.getShareUrl() + ", gallery=" + this.getGallery() + ", goodsCategoryId=" + this.getGoodsCategoryId() + ", brandId=" + this.getBrandId() + ", weight=" + this.getWeight() + ", volume=" + this.getVolume() + ", specialFreightId=" + this.getSpecialFreightId() + ", beSpecial=" + this.getBeSpecial() + ", price=" + this.getPrice() + ", beDeleted=" + this.getBeDeleted() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ")";
    }
}
