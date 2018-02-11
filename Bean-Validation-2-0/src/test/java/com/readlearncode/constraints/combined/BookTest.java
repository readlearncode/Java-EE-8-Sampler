package com.readlearncode.constraints.combined;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;

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
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void givenBeanWithConstraints_shouldValidate() {

        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setTitle(Optional.of("Fun with Java EE"));
        book.setAuthor(new Author("Alex", "Theedom", "email@example.org.com.net"));
        book.setPrice(10F);
        book.setPages(200);
        book.setDaysToPromotionEnd(-20);
        book.setDaysToRelease(-10);
        book.setReleased(Year.of(2017));
        book.setNextVersionRelease(LocalDate.now());
        book.setInPrint(true);
        book.setBinding(Binding.SOFT_BACK);

        HashMap<String, Book> map = new HashMap<>();
        map.put("Non-Fiction", book);
        book.setOtherBooksByAuthor(map);

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Introduction");
        book.setChapterTitles(list1);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("French");
        list2.add("English");
        book.setLanguages(list2);

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);

        assertThat(constraintViolations.size()).isEqualTo(1);

    }


}