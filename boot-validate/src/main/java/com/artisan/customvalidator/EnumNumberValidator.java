package com.artisan.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */
public class EnumNumberValidator implements ConstraintValidator<EnumInteger, Number> {
    private List<Integer> enumStringList;

    @Override
    public void initialize(EnumInteger constraintAnnotation) {
        enumStringList = new ArrayList<>();
        int[] values = constraintAnnotation.value();
        for (int value : values) {
            enumStringList.add(value);
        }
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return enumStringList.contains(value.intValue());
    }
}

