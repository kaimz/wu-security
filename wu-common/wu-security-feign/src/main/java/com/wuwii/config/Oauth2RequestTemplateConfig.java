package com.wuwii.config;

import org.jboss.logging.Logger;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Created by KronChan on 18/11/8 下午5:58.
 */
@Configuration
@EnableOAuth2Client
public class Oauth2RequestTemplateConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.DEBUG;
    }

    @Bean("oAuth2RestTemplate")
    public OAuth2RestTemplate restTemplate(UserInfoRestTemplateFactory factory) {
        return factory.getUserInfoRestTemplate();
    }

}
