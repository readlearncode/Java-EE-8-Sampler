package com.readlearncode.containervalidation;

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
public class ClientChoiceTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void givenListWithConstraints_shouldValidate() {
        ClientChoice clientChoice = new ClientChoice();
        clientChoice.addChoices(new Choice(1, "Pineapple"));
        clientChoice.addChoices(new Choice(2, "Banana"));
        clientChoice.addChoices(new Choice(3, "Apple"));

        Set<ConstraintViolation<ClientChoice>> constraintViolations = validator.validate(clientChoice);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }

    @Test
    public void givenListWithConstraints_shouldNotValidate() {
        ClientChoice clientChoice = new ClientChoice();
        clientChoice.addChoices(new Choice(1, "Fish"));
        clientChoice.addChoices(new Choice(2, "Egg"));
        clientChoice.addChoices(new Choice(3, "Apple"));

        Set<ConstraintViolation<ClientChoice>> constraintViolations = validator.validate(clientChoice);
        assertThat(constraintViolations.size()).isEqualTo(2);
    }

    @Test
    public void givenMapWithConstraints_shouldValidate() {

        ClientChoice clientChoice = new ClientChoice();

        clientChoice.addClientChoices("John", new ArrayList<Choice>() {{
            add(new Choice(1, "Roast Lamb"));
            add(new Choice(1, "Ice Cream"));
            add(new Choice(1, "Apple"));
        }});

        clientChoice.addClientChoices("May", new ArrayList<Choice>() {{
            add(new Choice(1, "Grapes"));
            add(new Choice(1, "Beef Stake"));
            add(new Choice(1, "Pizza"));
        }});

        Set<ConstraintViolation<ClientChoice>> constraintViolations = validator.validate(clientChoice);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }

    @Test
    public void givenMapWithConstraints_shouldNotValidate() {

        ClientChoice clientChoice = new ClientChoice();

        clientChoice.addClientChoices("John", new ArrayList<Choice>() {{
            add(new Choice(1, "Fish"));
            add(new Choice(1, "Egg"));
            add(new Choice(1, "Apple"));
        }});

        clientChoice.addClientChoices("May", new ArrayList<Choice>() {{
            add(new Choice(1, "Grapes"));
            add(new Choice(1, "Beef Stake"));
            add(new Choice(1, "Pizza"));
        }});

        Set<ConstraintViolation<ClientChoice>> constraintViolations = validator.validate(clientChoice);
        assertThat(constraintViolations.size()).isEqualTo(2);
    }
}