package com.xmu.wowoto.wowomall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.xmu.wowoto.wowomall.mapper")
@EnableEurekaClient
@EnableScheduling
/**
 * @author wowoto
 */
public class WowomallApplication {
    public static void main(String[] args) {
        SpringApplication.run(WowomallApplication.class, args);
    }

}
