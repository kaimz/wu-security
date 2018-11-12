package com.wuwii.feign.hystrix;

import com.wuwii.feign.TestClient;
import org.springframework.stereotype.Component;

/**
 * Created by KronChan on 18/11/12 上午10:56.
 */
@Component
public class TestClientFallback implements TestClient {
    @Override
    public String test(String s) {
        return "Got the message form remote producer failed.";
    }
}
