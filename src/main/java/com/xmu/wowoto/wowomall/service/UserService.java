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
    User getUserById(@PathVariable Integer userId);
}
