package com.wuwii.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by KronChan on 18/11/2 下午3:43.
 */
@RestController
@RequestMapping("/sso")
public class SsoController {

    @GetMapping
    public Principal user(Principal user) {
        return user;
    }

    /**
     * 测试 OAuth2Request
     *
     * @param s
     * @param request
     * @return
     */
    @GetMapping("/test/{s}")
    public String test(@PathVariable("s") String s, HttpServletRequest request) {
        throw new IllegalArgumentException();
    }
}
