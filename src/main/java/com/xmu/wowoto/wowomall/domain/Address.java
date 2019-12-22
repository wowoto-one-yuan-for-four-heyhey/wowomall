package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.domain.Po.AddressPo;

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

    public boolean equals(final Object o) {
        if (o == this){ return true;}
        if (!(o instanceof Address)) {return false;}
        final Address other = (Address) o;
        if (!other.canEqual((Object) this)) {return false;}
        if (!super.equals(o)) {return false;}
        final Object this$province = this.getProvince();
        final Object other$province = other.getProvince();
        if (this$province == null ? other$province != null : !this$province.equals(other$province)) {return false;}
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) {return false;}
        final Object this$county = this.getCounty();
        final Object other$county = other.getCounty();
        if (this$county == null ? other$county != null : !this$county.equals(other$county)) {return false;}
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Address;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final Object $province = this.getProvince();
        result = result * PRIME + ($province == null ? 43 : $province.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $county = this.getCounty();
        result = result * PRIME + ($county == null ? 43 : $county.hashCode());
        return result;
    }

    public String toString() {
        return "Address(province=" + this.getProvince() + ", city=" + this.getCity() + ", county=" + this.getCounty() + ")";
    }
}
