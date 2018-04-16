package com.wuwii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WuCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WuCenterApplication.class, args);
    }
}
