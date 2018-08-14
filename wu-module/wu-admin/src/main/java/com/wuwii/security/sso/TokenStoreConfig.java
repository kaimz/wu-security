package com.wuwii.security.sso;

import com.wuwii.security.jwt.JwtOauth2Properties;
import com.wuwii.security.jwt.JwtTokenEnhancer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Created by KronChan on 18/7/10 下午12:57.
 */
@Configuration
public class TokenStoreConfig {

    @Bean
    @ConditionalOnMissingBean(name = "jwtOauth2Properties")
    public JwtOauth2Properties jwtOauth2Properties() {
        return new JwtOauth2Properties();
    }

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey(jwtOauth2Properties().getSignKey());//生成签名的key
        return accessTokenConverter;
    }

    @Bean
    @ConditionalOnMissingBean(name = "jwtTokenEnhancer")
    public TokenEnhancer jwtTokenEnhancer() {
        return new JwtTokenEnhancer();
    }

}
