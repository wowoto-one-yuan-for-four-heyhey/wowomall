package com.xmu.wowoto.wowomall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/18 16:19
 */
@Service
@FeignClient("afterSalesService")
public interface RemoteAftersalesService {

    /**
     * 更新一项order
     * @param id
     * @return
     */
    @GetMapping("afterSaleServices/{id}")
    String getAftersales(@PathVariable("id") Integer id);

}
