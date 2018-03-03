package com.readlearncode.constraints.repeatable;

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
public class RepeatedConstraintTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void givenBeanWithValidDomain_shouldValidate() {

        RepeatedConstraint repeatedConstraint = new RepeatedConstraint();

        repeatedConstraint.setText("www.readlearncode.com");

        Set<ConstraintViolation<RepeatedConstraint>> constraintViolations = validator.validate(repeatedConstraint);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }


    @Test
    public void givenBeanWithInValidDomain_shouldNotValidate() {

        RepeatedConstraint repeatedConstraint = new RepeatedConstraint();

        repeatedConstraint.setText("www.readlearncode.net");

        Set<ConstraintViolation<RepeatedConstraint>> constraintViolations = validator.validate(repeatedConstraint);
        assertThat(constraintViolations.size()).isEqualTo(1);
    }
}