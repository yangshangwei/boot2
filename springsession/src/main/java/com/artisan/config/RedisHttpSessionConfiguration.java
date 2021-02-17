package com.artisan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/2/16 14:12
 * @mark: show me the code , change the world
 */
@Configuration
@EnableRedisHttpSession
public class RedisHttpSessionConfiguration {


    @Bean(name = "springSessionDefaultRedisSerializer")
    public RedisSerializer springSessionDefaultRedisSerializer() {
        return RedisSerializer.json();
    }
}
    