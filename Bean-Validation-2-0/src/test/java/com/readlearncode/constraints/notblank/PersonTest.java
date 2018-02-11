package com.readlearncode.constraints.notblank;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
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
    public void givenBeanWithNotBlankFields_shouldValidate() {
        Person person = new Person();
        person.setFirstName("Alex");
        person.setSecondName("Theedom");
        person.setEmail("alex.theedom@example.com");
        person.setCars(new ArrayList<String>() {
            {
                add("BMW");
                add("Toyota");
                add("Fiat");
            }
        });

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }

    @Test
    public void givenBeanWithNullFields_shouldNotValidate() {
        Person person = new Person();
        person.setFirstName(null);
        person.setSecondName(null);
        person.setEmail(null);
        person.setCars(new ArrayList<String>() {
            {
                add(null);
            }
        });

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertThat(constraintViolations.size()).isEqualTo(4);
    }


    @Test
    public void givenBeanWithBlankFields_shouldNotValidate() {
        Person person = new Person();
        person.setFirstName("       ");
        person.setSecondName("");
        person.setEmail("  ");
        person.setCars(new ArrayList<String>() {
            {
                add(" ");
            }
        });

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        assertThat(constraintViolations.size()).isEqualTo(4);
    }

    @Test
    public void givenBeanWithEmptyElementInCollection_shouldNotValidate() {
        Person person = new Person();
        person.setCars(new ArrayList<String>() {
            {
                add(null);
            }
        });

        Set<ConstraintViolation<Person>> constraintViolations = validator.validateProperty(person, "cars");
        assertThat(constraintViolations.size()).isEqualTo(1);
    }

}