package com.xmu.wowoto.wowomall.domain;

import java.util.List;

public class WowoOrder extends com.xmu.wowoto.wowomall.entity.Order {

    private WowoUser wowoUser;

    private List<WowoOrderItem> wowoOrderItems;

    private WowoAddress realWowoAddress;

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
}
