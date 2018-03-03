package com.readlearncode.containervalidation;

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
public class FavouriteTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void givenListWithConstraints_shouldNotValidate() {

        ClientFavourites clientFavourites = new ClientFavourites();
        clientFavourites.addFavourites(new Favourite(1, "Cheese"));
        clientFavourites.addFavourites(new Favourite(2, "Ham"));
        clientFavourites.addFavourites(new Favourite(3, "Egg"));

        Set<ConstraintViolation<ClientFavourites>> constraintViolations = validator.validate(clientFavourites);
        assertThat(constraintViolations.size()).isEqualTo(2);

    }


}