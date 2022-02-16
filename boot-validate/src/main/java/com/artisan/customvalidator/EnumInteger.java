package com.artisan.customvalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author 小工匠
 * @version 1.0
 * @Des 扩展int枚举校验
 * @mark: show me the code , change the world
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(EnumInteger.List.class)
@Documented
@Constraint(validatedBy = EnumNumberValidator.class)
public @interface EnumInteger {

    String message() default "value not in enum values.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * @return date must in this value array
     */
    int[] value();

    /**
     * Defines several {@link EnumInteger} annotations on the same element.
     *
     * @see EnumInteger
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        EnumInteger[] value();
    }
}
