package com.readlearncode.constraints.email;

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
public class PersonTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void givenBeanWithValidEmailConstraints_shouldValidate() {
        Person person = new Person();
        person.setEmail("alex.theedom@example.com");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }

    @Test
    public void givenBeanWithInvalidEmailConstraints_shouldNotValidate() {
        Person person = new Person();
        person.setEmail("alex.theedom@example");

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }

}