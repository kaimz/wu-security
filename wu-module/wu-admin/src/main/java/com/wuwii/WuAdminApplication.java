package com.wuwii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableConfigurationProperties
public class WuAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(WuAdminApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
