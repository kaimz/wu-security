package com.wuwii.security.sso;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by KronChan on 18/7/11 上午10:38.
 */
@Data
@ConfigurationProperties(prefix = "wu.security.oauth2")
public class ClientProperties {

    private SsoClient[] clients;

    @Data
    public static class SsoClient {
        private String id;

        private String secure;
    }
}
