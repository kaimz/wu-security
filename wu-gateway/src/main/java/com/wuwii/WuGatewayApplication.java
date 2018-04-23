package com.wuwii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

/**
 * @author KronChan
 * @version 1.0
 * @since <pre>2018/4/16 22:54</pre>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WuGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(WuGatewayApplication.class, args);
    }

    @Bean
    public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
    }
}
