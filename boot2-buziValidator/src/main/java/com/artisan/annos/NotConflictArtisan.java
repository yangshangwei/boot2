package com.artisan.annos;

import com.artisan.validate.ArtisanValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *  表示一个用户的信息是无冲突的
 *  “无冲突”是指该用户的敏感信息与其他用户不重合，譬如将一个注册用户的邮箱手机，修改成与另外一个已存在的注册用户一致的值，这便是冲突
 * @author artisan
 */
@Documented
@Retention(RUNTIME)
@Target({FIELD, METHOD, PARAMETER, TYPE})
@Constraint(validatedBy = ArtisanValidator.NotConflictArtisanValidator.class)
public @interface NotConflictArtisan {


    String message() default "用户名称、邮箱、手机号码与现存用户产生重复";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
