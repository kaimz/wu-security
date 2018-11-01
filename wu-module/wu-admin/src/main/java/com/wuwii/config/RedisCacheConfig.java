package com.wuwii.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * https://blog.csdn.net/sy793314598/article/details/80719224
 * Created by KronChan on 18/11/1 下午6:16.
 */
@Configuration
@EnableCaching
public class RedisCacheConfig {
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheManager redisCacheManager = RedisCacheManager.create(factory);
        // 设置缓存最大时间
        return redisCacheManager;
    }
}
