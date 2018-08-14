package com.wuwii.security.sso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by KronChan on 2018/4/28 18:23.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Bean
    public ClientProperties clientProperties() {
        return new ClientProperties();
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //      .successHandler(appLoginInSuccessHandler)//登录成功处理器
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .mvcMatchers("/favicon.ico").permitAll().and().authorizeRequests()
                .anyRequest().authenticated().and()
                .csrf().disable();
        /*http.
                csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();*/
    }
}
