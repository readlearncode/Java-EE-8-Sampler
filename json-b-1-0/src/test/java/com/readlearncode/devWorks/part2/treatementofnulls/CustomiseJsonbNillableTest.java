package com.readlearncode.devWorks.part2.treatementofnulls;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CustomiseJsonbNillableTest {

    @Test
    public void givenJsonbNillableAtClass_shouldPreserveNullsOnSerialisation() {
        String expectedJson = "{\"author\":null,\"id\":\"ABC-123-XYZ\",\"title\":\"Fun with JSON-B\"}";
        Book book = new Book("ABC-123-XYZ", "Fun with JSON-B", null);
        String actualJson = JsonbBuilder.create().toJson(book);
        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    public void givenJsonbNillableAtClass_shouldPreserveNullsOnDeserialisation() {
        String json = "{\"author\":null,\"id\":\"ABC-123-XYZ\",\"title\":\"Fun with JSON-B\"}";
        Book actualBook = JsonbBuilder.create().fromJson(json, Book.class);
        assertThat(actualBook.getAuthor()).isNull();
        assertThat(actualBook.getId()).isEqualTo("ABC-123-XYZ");
        assertThat(actualBook.getTitle()).isEqualTo("Fun with JSON-B");
    }

    @Test
    public void givenJsonbPropertyNillableIdTrue_shouldPreserveNullsOnSerialisation() {
        String expectedJson = "{\"authorName\":null,\"title\":\"Fun with JSON binding\"}";
        Magazine magazine = new Magazine("Fun with JSON binding", null, null);
        String actualJson = JsonbBuilder.create().toJson(magazine);
        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    public void givenJsonbPropertyNillableIdTrue_shouldPreserveNullsOnDeserialisation() {
        String json = "{\"authorName\":null,\"title\":\"Fun with JSON binding\"}";
        Magazine actualMagazine = JsonbBuilder.create().fromJson(json, Magazine.class);
        assertThat(actualMagazine.getAuthorName()).isNull();
        assertThat(actualMagazine.getAlternativeTitle()).isNull();
        assertThat(actualMagazine.getTitle()).isEqualTo("Fun with JSON binding");
    }

}