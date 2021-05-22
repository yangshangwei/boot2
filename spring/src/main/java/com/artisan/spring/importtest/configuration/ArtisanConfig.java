package com.artisan.spring.importtest.configuration;

import com.artisan.spring.beans.Artisan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/5/22 8:50
 * @mark: show me the code , change the world
 */


@Configuration
public class ArtisanConfig {

    @Bean
    public Artisan artisan() {
        Artisan artisan =  new Artisan();
        artisan.setName("小工匠");
        artisan.setAge(18);
        return artisan;
    }
}
    