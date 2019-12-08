package com.xmu.wowoto.wowomall;


import com.xmu.wowoto.wowomall.util.RedisUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xmu.wowoto.wowomall.mapper")
public class WowomallApplication {
    public static void main(String[] args) {
        SpringApplication.run(WowomallApplication.class, args);
    }

}
