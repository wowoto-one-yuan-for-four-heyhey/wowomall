package com.xmu.wowoto.wowomall.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xmu.wowoto.wowomall.entity.Goods;


/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@JsonSerialize(as = Goods.class)
public class WowoGoods extends Goods {

}
