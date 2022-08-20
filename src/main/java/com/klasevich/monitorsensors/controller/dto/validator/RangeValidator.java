package com.klasevich.monitorsensors.controller.dto.validator;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<ValidRange, Object> {

    private String from;

    private String to;

    @Override
    public void initialize(ValidRange constraintAnnotation) {
        this.from = constraintAnnotation.from();
        this.to = constraintAnnotation.to();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fromValue = new BeanWrapperImpl(value).getPropertyValue(from);
        Object toValue = new BeanWrapperImpl(value).getPropertyValue(to);
        return ((Integer) fromValue) < ((Integer) toValue);
    }
}
