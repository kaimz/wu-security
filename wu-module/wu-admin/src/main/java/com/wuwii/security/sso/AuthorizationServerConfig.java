package com.wuwii.security.sso;

import com.wuwii.security.jwt.JwtOauth2Properties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KronChan on 2018/4/27 18:26.
 */
@Configuration
@ConfigurationProperties(prefix = "wu.security.oauth2")
@EnableAuthorizationServer
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final JwtOauth2Properties oAuth2Properties;

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private final TokenStore tokenStore;

    private final JwtAccessTokenConverter jwtAccessTokenConverter;

    private final TokenEnhancer jwtTokenEnhancer;

    private final PasswordEncoder passwordEncoder;

    @Getter
    @Setter
    private Integer access;

    @Getter
    @Setter
    private Integer refresh;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
        //扩展token返回结果
        if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null) {
            TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
            List<TokenEnhancer> enhancerList = new ArrayList();
            enhancerList.add(jwtTokenEnhancer);
            enhancerList.add(jwtAccessTokenConverter);
            tokenEnhancerChain.setTokenEnhancers(enhancerList);
            //jwt
            endpoints.tokenEnhancer(tokenEnhancerChain)
                    .accessTokenConverter(jwtAccessTokenConverter);
        }
    }

    /**
     * 配置客户端一些信息
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder build = clients.inMemory();
        ClientProperties clientProperties = oAuth2Properties.getClientProperties();
        for (ClientProperties.SsoClient client : clientProperties.getClients()) {
            build.withClient(client.getId())
                    .secret(passwordEncoder.encode(client.getSecret()))
                    .accessTokenValiditySeconds(access)
                    .refreshTokenValiditySeconds(refresh)
                    .authorizedGrantTypes("refresh_token", "password", "authorization_code")//OAuth2支持的验证模式
                    .redirectUris("http://wuwii.com")
                    .scopes("all");
        }
    }

//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
//        //允许表单认证
//        oauthServer.allowFormAuthenticationForClients();
//        oauthServer.passwordEncoder(passwordEncoder);
//    }

    /**
     * springSecurity 授权表达式，
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()");
        security.checkTokenAccess("isAuthenticated()");
    }
    /**
     * 客户端一些配置
     *
     * @param clients
     * @throws Exception
     *//*
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("merryyou1")
                .secret("merryyousecrect1")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("all")
                .and()
                .withClient("merryyou2")
                .secret("merryyousecrect2")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("all");
    }

    *//**
     * 配置jwttokenStore
     *
     * @param endpoints
     * @throws Exception
     *//*
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore()).accessTokenConverter(jwtAccessTokenConverter());
    }

    *//**
     * springSecurity 授权表达式，访问merryyou tokenkey时需要经过认证
     *
     * @param security
     * @throws Exception
     *//*
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
       // security.tokenKeyAccess("isAuthenticated()");
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    *//**
     * JWTtokenStore
     *
     * @return
     *//*
    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    *//**
     * // 可以使用密钥加密
     * https://blog.csdn.net/chenjianandiyi/article/details/78604376
     * 生成JTW token
     *
     * @return
     *//*
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("kronchan");
        return converter;
    }*/
}
