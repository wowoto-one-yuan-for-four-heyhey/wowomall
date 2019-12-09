package com.xmu.wowoto.wowomall.domain;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xmu.wowoto.wowomall.entity.Address;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@JsonSerialize(as = Address.class)
public class WowoAddress extends com.xmu.wowoto.wowomall.entity.Address {

}
