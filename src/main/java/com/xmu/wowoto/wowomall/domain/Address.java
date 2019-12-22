package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.domain.po.AddressPo;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:地址对象
 * @Data:Created in 14:50 2019/12/11
 **/
public class Address extends AddressPo {

    private String province;

    private String city;

    private String county;

    public String getProvince() {
        return this.province;
    }

    public String getCity() {
        return this.city;
    }

    public String getCounty() {
        return this.county;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this){ return true;}
        if (!(o instanceof Address)) {return false;}
        final Address other = (Address) o;
        if (!other.canEqual((Object) this)) {return false;}
        if (!super.equals(o)) {return false;}
        final Object thisgmtCreate = this.getProvince();
        final Object othergmtCreate = other.getProvince();
        if (thisgmtCreate == null ? othergmtCreate != null : !thisgmtCreate.equals(othergmtCreate)) {return false;}
        final Object thiscity = this.getCity();
        final Object othercity = other.getCity();
        if (thiscity == null ? othercity != null : !thiscity.equals(othercity)) {return false;}
        final Object thiscounty = this.getCounty();
        final Object othercounty = other.getCounty();
        if (thiscounty == null ? othercounty != null : !thiscounty.equals(othercounty)) {return false;}
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof Address;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = super.hashCode();
        final Object gmtCreate = this.getProvince();
        result = result * prime + (gmtCreate == null ? 43 : gmtCreate.hashCode());
        final Object city = this.getCity();
        result = result * prime + (city == null ? 43 : city.hashCode());
        final Object county = this.getCounty();
        result = result * prime + (county == null ? 43 : county.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Address(province=" + this.getProvince() + ", city=" + this.getCity() + ", county=" + this.getCounty() + ")";
    }
}
