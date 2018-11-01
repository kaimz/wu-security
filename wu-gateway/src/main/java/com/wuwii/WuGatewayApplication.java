package com.wuwii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author KronChan
 * @version 1.0
 * @since <pre>2018/4/16 22:54</pre>
 */
@EnableDiscoveryClient
@SpringBootApplication
public class WuGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(WuGatewayApplication.class, args);
    }

}
