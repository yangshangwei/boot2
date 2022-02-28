package com.artisan.startvalidator.config;

import com.artisan.startvalidator.validator.ArtisanCustomConfigPropertiesValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */

@Configuration
public class AppConfiguration {


    /**
     * bean的方法名必须要 configurationPropertiesValidator，否则启动的时候不会执行该校验
     *
     * @return
     */
    @Bean
    public ArtisanCustomConfigPropertiesValidator configurationPropertiesValidator() {
        return new ArtisanCustomConfigPropertiesValidator();
    }
}
    