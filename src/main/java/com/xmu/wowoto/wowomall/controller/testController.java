package com.xmu.wowoto.wowomall.controller;

import com.xmu.wowoto.wowomall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class testController {
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("redis")
    public String get()
    {
        //设置键值对
        redisUtil.set("test","10086");
        //获取值
        String a=redisUtil.get("test");
        //转成数字并减一,再转成String
        Integer b=Integer.parseInt(a);
        b=b-1;
        String c=b.toString();
        //写回值
        redisUtil.getAndSet("test",c);
        return redisUtil.get("test");
    }
}
