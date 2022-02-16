package com.artisan.customvalidator;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */
@Slf4j
public class EnumStringValidator implements ConstraintValidator<EnumString, String> {
    private List<String> enumStringList;

    @Override
    public void initialize(EnumString constraintAnnotation) {
        log.info("EnumStringValidator initialize.....");
        enumStringList = Arrays.asList(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return enumStringList.contains(value);
    }
}
