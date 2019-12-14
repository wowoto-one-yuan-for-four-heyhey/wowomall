package com.xmu.wowoto.wowomall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.xmu.wowoto.wowomall.mapper")
@EnableEurekaClient
public class WowomallApplication {
    public static void main(String[] args) {
        SpringApplication.run(WowomallApplication.class, args);
    }

}
