package com.wuwii.feign;

import com.wuwii.feign.hystrix.TestClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by KronChan on 18/11/2 下午5:34.
 */

@FeignClient(value = "wu-admin", path = "/", fallback = TestClientFallback.class)
public interface TestClient {

    @GetMapping("/sso/test/{s}")
    String test(@PathVariable("s") String s);
}

