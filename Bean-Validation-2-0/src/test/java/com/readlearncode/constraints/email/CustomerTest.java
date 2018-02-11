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
public class CustomerTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void givenBeanWithValidEmailConstraints_shouldValidate() {
        Customer customer = new Customer();
        customer.setEmail("alex.theedom@example.com");

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }

    @Test
    public void givenBeanWithInvalidEmailConstraints_shouldNotValidate() {
        Customer customer = new Customer();
        customer.setEmail("alex.theedom@example.co.uk");

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
        assertThat(constraintViolations.size()).isEqualTo(1);
    }

}