package com.artisan.configuration;


import com.artisan.beans.Artisan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小工匠
 * @version 1.0
 * @description:  自定义的配置类  类比第三方的配置类
 * @date 2021/5/22 8:50
 * @mark: show me the code , change the world
 */


@Configuration
public class ArtisanConfig {

    @Bean
    public Artisan artisan() {
        Artisan artisan = new Artisan();
        artisan.setName("小工匠");
        artisan.setAge(18);
        return artisan;
    }
}
    