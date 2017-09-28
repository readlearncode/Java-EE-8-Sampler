package com.readlearncode.devWorks.part1.basictypes;

import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BasicTypeExampleTest {

    @Test
    public void serializeBook() {

        String expectedJson = "{\"count\":4,\"firstname\":\"John\",\"inPrint\":true,\"lastname\":\"Smith\",\"middleInitial\":\"J\",\"pages\":200,\"price\":59.99,\"title\":\"Fun with Java\",\"version\":5}";

        Book book = new Book();
        book.setTitle("Fun with Java");
        book.setFirstname("John");
        book.setMiddleInitial('J');
        book.setLastname("Smith");
        book.setPrice(59.99f);
        book.setInPrint(true);
        book.setPages(200);
        book.setVersion((byte) 5);
        book.setCount(new AtomicInteger(4));

        String actualJson = JsonbBuilder.create().toJson(book);

        assertThat(actualJson).isEqualTo(expectedJson);

        /*
            {
              "count": 4,
              "firstname": "John",
              "inPrint": true,
              "lastname": "Smith",
              "middleInitial": "J",
              "pages": 200,
              "price": 59.99,
              "title": "Fun with Java",
              "version": 5
            }
         */
    }

    @Test
    public void deserializeBook() {

        Book expectedBook = new Book();
        expectedBook.setTitle("Fun with Java");
        expectedBook.setFirstname("John");
        expectedBook.setMiddleInitial('J');
        expectedBook.setLastname("Smith");
        expectedBook.setPrice(59.99f);
        expectedBook.setInPrint(true);
        expectedBook.setPages(200);
        expectedBook.setVersion((byte) 5);
        expectedBook.setCount(new AtomicInteger(4));

        String json = "{\"count\":4,\"firstname\":\"John\",\"inPrint\":true,\"lastname\":\"Smith\",\"middleInitial\":\"J\",\"pages\":200,\"price\":59.99,\"title\":\"Fun with Java\",\"version\":5}";

        assertThatThrownBy(() -> JsonbBuilder.create().fromJson(json, Book.class))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("argument type mismatch");

    }

    @Test
    public void givenJsonData_whenDeserialiseFieldAtomicInteger_shouldThrowException() {

        Jsonb jsonb = JsonbBuilder.create();

        assertThatThrownBy(() -> jsonb.fromJson(
                jsonb.toJson(new SimpleBook(new AtomicInteger(10))),
                SimpleBook.class))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("argument type mismatch");

    }

    @Test
    public void givenObject_shouldSerialiseInLexicographicalOrder(){

        Jsonb jsonb = JsonbBuilder.create();

        String actualJson = jsonb.toJson(new LexicographicalOrder());

        assertThat(actualJson).isEqualTo("{\"animal\":\"Cat\",\"bread\":\"Chiapata\",\"car\":\"Ford\",\"dog\":\"Labradoodle\"}");
    }

}