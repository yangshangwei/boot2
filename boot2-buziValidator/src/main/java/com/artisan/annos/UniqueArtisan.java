package com.artisan.annos;


import com.artisan.validate.ArtisanValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


/**
 *
 * 自定义 "用户唯一" 校验注解 .唯一包含 -----------> 用户名+手机号码+邮箱
 * @author artisan
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Constraint(validatedBy = ArtisanValidator.UniqueArtisanValidator.class)
public @interface UniqueArtisan {

    String message() default "用户名、手机号码、邮箱不允许与现存用户重复";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
