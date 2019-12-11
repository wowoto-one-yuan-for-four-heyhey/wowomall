package com.xmu.wowoto.wowomall;


import com.xmu.wowoto.wowomall.util.RedisUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.xmu.wowoto.wowomall.mapper")
@EnableEurekaClient
public class WowomallApplication {
    public static void main(String[] args) {
        SpringApplication.run(WowomallApplication.class, args);
    }

}
