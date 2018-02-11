package com.readlearncode.constraints.positive;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class NumbersTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void givenBeanWithPositiveFields_shouldValidate() {

        Numbers numbers = new Numbers();

        numbers.setABigDecimal(BigDecimal.TEN);
        numbers.setAPrimitiveNumber(5);

        LongAdder longAdder = new LongAdder();
        longAdder.add(5);
        numbers.setALongAdder(longAdder);

        Set<ConstraintViolation<Numbers>> constraintViolations = validator.validate(numbers);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }

    @Test
    public void givenBeanWithNegativeFields_shouldNotValidate() {
        Numbers numbers = new Numbers();

        numbers.setABigDecimal(BigDecimal.valueOf(-1));
        numbers.setAPrimitiveNumber(-5);

        LongAdder longAdder = new LongAdder();
        longAdder.add(-5);
        numbers.setALongAdder(longAdder);

        Set<ConstraintViolation<Numbers>> constraintViolations = validator.validate(numbers);
        assertThat(constraintViolations.size()).isEqualTo(3);
    }


    @Test
    public void givenBeanWithZeroFields_shouldValidate() {
        Numbers numbers = new Numbers();

        numbers.setABigDecimal(BigDecimal.ZERO);
        numbers.setAPrimitiveNumber(0);

        LongAdder longAdder = new LongAdder();
        longAdder.add(0);
        numbers.setALongAdder(longAdder);

        Set<ConstraintViolation<Numbers>> constraintViolations = validator.validate(numbers);
        assertThat(constraintViolations.size()).isEqualTo(3);
    }

}