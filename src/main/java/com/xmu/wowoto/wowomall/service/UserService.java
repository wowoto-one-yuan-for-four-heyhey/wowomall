package com.xmu.wowoto.wowomall.service;

import com.xmu.wowoto.wowomall.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/15 20:25
 */
@Service
public interface UserService {

    /**
     * 根据Id拿到user
     * @param userId
     * @return
     */
    User getUserById(@PathVariable Integer userId);

    /**
     * 添加用户返点
     * @param userId
     * @param rebate
     * @return
     */
    Integer addRebate(Integer userId,Integer rebate);
}
