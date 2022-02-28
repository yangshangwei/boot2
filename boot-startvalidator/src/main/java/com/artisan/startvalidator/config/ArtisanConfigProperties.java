package com.artisan.startvalidator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */

@Validated
@Component
@Data
@ConfigurationProperties(prefix = "artisan")
public class ArtisanConfigProperties {

//    @NotEmpty(message = "必须配置[artisan.code]属性")
//    private String code;


    private String code;
}
    