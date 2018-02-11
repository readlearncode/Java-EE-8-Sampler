package com.readlearncode.constraints.pastorpresent;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class DatesTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void givenBeanWithPresentAndPastFields_shouldValidate() {

        Dates dates = new Dates();

        dates.setPast(new Date(2007-1900, 11, 24));
        dates.setNow(LocalDate.now());
        //dates.setFuture(Year.parse("2020"));

        Set<ConstraintViolation<Dates>> constraintViolations = validator.validate(dates);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }


    @Test
    public void givenBeanWithFutureFields_shouldNotValidate() {

        Dates dates = new Dates();

        dates.setFuture(Year.parse("2020"));

        Set<ConstraintViolation<Dates>> constraintViolations = validator.validate(dates);
        assertThat(constraintViolations.size()).isEqualTo(1);
    }
}