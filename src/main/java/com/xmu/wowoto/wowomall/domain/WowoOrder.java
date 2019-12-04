package com.xmu.wowoto.wowomall.domain;

import com.xmu.wowoto.wowomall.entity.Order;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("WowoOrder")
public class WowoOrder extends com.xmu.wowoto.wowomall.entity.Order {

    private WowoUser wowoUser;

    private List<WowoOrderItem> wowoOrderItems;

    private WowoAddress wowoAddress;

    public WowoUser getWowoUser() {
        return wowoUser;
    }

    public void setWowoUser(WowoUser wowoUser) {
        this.wowoUser = wowoUser;
    }

    public List<WowoOrderItem> getWowoOrderItems() {
        return wowoOrderItems;
    }

    public void setWowoOrderItems(List<WowoOrderItem> wowoOrderItems) {
        this.wowoOrderItems = wowoOrderItems;
    }

    public WowoAddress getWowoAddress() {
        return wowoAddress;
    }

    public void setWowoAddress(WowoAddress wowoAddress) {
        this.wowoAddress = wowoAddress;
    }
}