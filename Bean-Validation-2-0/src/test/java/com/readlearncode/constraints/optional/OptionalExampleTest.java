package com.readlearncode.constraints.optional;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class OptionalExampleTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void givenBeanWithOptionalStringExample_shouldValidate() {

        OptionalExample optionalExample = new OptionalExample();

        optionalExample.setText("Cabbage");
        optionalExample.setName("Potatoes");

        Set<ConstraintViolation<OptionalExample>> constraintViolations = validator.validate(optionalExample);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }

    @Test
    public void givenBeanWithOptionalStringExample_shouldNotValidate() {

        OptionalExample optionalExample = new OptionalExample();

        optionalExample.setText("      ");
        // name field not set so that is will be null

        Set<ConstraintViolation<OptionalExample>> constraintViolations = validator.validate(optionalExample);
        assertThat(constraintViolations.size()).isEqualTo(2);
    }

    @Test
    public void givenBeanWithOptionalStringNullExample_shouldNotValidate() {

        OptionalExample optionalExample = new OptionalExample();

        optionalExample.setText("      ");
        optionalExample.setName(null);

        Set<ConstraintViolation<OptionalExample>> constraintViolations = validator.validate(optionalExample);
        assertThat(constraintViolations.size()).isEqualTo(1);
    }


}