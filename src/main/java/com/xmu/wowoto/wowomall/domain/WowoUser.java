package com.xmu.wowoto.wowomall.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xmu.wowoto.wowomall.entity.User;

@JsonSerialize(as = User.class)
public class WowoUser extends com.xmu.wowoto.wowomall.entity.User {

}
