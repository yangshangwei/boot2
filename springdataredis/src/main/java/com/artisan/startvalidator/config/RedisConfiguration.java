package com.artisan.startvalidator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/2/16 21:07
 * @mark: show me the code , change the world
 */


@Configuration
public class RedisConfiguration {

    @Autowired
    private RedisConnectionFactory connectionFactory;


    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        // 创建 RedisTemplate 对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // 设置 RedisConnection 工厂。 它就是实现多种 Java Redis 客户端接入的秘密工厂
        template.setConnectionFactory(connectionFactory);

        // 使用 String 序列化方式，序列化 KEY 。
        template.setKeySerializer(RedisSerializer.string());

        // 使用 JSON 序列化方式（库是 Jackson ），序列化 VALUE 。
        template.setValueSerializer(RedisSerializer.json());

        return template;
    }
}
    