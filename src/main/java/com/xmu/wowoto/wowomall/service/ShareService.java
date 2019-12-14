package com.xmu.wowoto.wowomall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 *
 * @author wowoto
 * @date 12/08/2019
 */
@Service
@FeignClient("shareService")
public interface ShareService {



}
