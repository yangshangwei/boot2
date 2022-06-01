package com.artisans.config;

import com.artisans.beans.AA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小工匠
 * @version 1.0
 * @date 2022/4/13 0:00
 * @mark: show me the code , change the world
 */

@Configuration
public class AnotherConfig {

    @Bean
    public AA aa() {
        return new AA();
    }
}
    