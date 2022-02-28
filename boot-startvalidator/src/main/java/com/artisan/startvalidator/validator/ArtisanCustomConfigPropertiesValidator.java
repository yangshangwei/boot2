package com.artisan.startvalidator.validator;


import com.artisan.startvalidator.config.ArtisanConfigProperties;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */
public class ArtisanCustomConfigPropertiesValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // 父类.class.isAssignableFrom(子类.class)
        return ArtisanConfigProperties.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ArtisanConfigProperties config = (ArtisanConfigProperties) target;
        if (StringUtils.isEmpty(config.getCode())) {
            errors.rejectValue("code", "artisan.code.empty", "[artisan.code] 属性必须要在配置文件application.properties中配置");
        } else if (config.getCode().length() < 8) {
            errors.rejectValue("id", "artisan.code.short", "[artisan.code] 属性的长度需要大于8");
        }

    }
}
    