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
public class BookTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void givenListWithConstraints_shouldValidate() {

        Book book = new Book();
        book.addChapterTitle("Chapter 1");

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }

    @Test
    public void givenListWithConstraints_shouldNotValidate() {

        Book book = new Book();
        book.addChapterTitle(" ");

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        assertThat(constraintViolations.size()).isEqualTo(1);
    }

    @Test
    public void givenMapWithConstraints_shouldValidate() {

        Book book = new Book();
        book.addAuthorChapter("Alex","Chapter 1");
        book.addAuthorChapter("John","Chapter 2");
        book.addAuthorChapter("May","Chapter 3");

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        assertThat(constraintViolations.size()).isEqualTo(0);
    }

    @Test
    public void givenMapWithConstraints_shouldNotValidate() {

        Book book = new Book();
        book.addAuthorChapter(" "," ");

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        assertThat(constraintViolations.size()).isEqualTo(2);
    }

}