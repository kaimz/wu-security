package com.wuwii.web;

import com.wuwii.feign.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KronChan on 18/11/12 上午10:59.
 */
@RestController
public class Client2Controller {
    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;
    @Autowired
    private TestClient testClient;

    @GetMapping("/user")
    public Authentication user(Authentication user) {
        return user;
    }

    @Value("${uaa}")
    String messagesUrl;

    @GetMapping("/api")
    public String home() {
        return oAuth2RestTemplate.getForObject(messagesUrl + "/sso/test/3", String.class);
    }

    @GetMapping("/test")
    public String test() {
        return testClient.test("sss");
    }
}
