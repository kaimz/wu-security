package com.wuwii.security.jwt;

import com.wuwii.security.sso.ClientProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by KronChan on 18/7/11 上午9:31.
 */
@Data
@ConfigurationProperties(prefix = "wu.security.oauth2.jwt")
public class JwtOauth2Properties {

    private String signKey;

    @Autowired
    private ClientProperties clientProperties;


}
