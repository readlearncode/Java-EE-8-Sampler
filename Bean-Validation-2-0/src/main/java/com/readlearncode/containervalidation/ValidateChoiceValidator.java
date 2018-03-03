package com.readlearncode.containervalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ValidateChoiceValidator implements ConstraintValidator<ValidateChoice, Choice> {

    @Override
    public void initialize(ValidateChoice validateChoice) {
    }

    @Override
    public boolean isValid(Choice choice, ConstraintValidatorContext context) {

        if (choice.getName() != null && choice.getName().length() > 4) return true;

        return false;
    }
}