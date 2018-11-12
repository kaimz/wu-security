package com.wuwii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KronChan on 18/11/4 下午11:20.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableOAuth2Client
@RestController
@EnableFeignClients(basePackages = {"com.wuwii.feign"})
public class Client2Application {
    public static void main(String[] args) {
        SpringApplication.run(Client2Application.class, args);
    }

}
