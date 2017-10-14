package com.readlearncode.devWorks.part2.propertname;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CustomisePropertyNameTest {

    @Test
    public void givenFieldAnnotateWithJsonbProperty_shouldChangeOfField() {
        Book book = new Book("ABC-123-XYZ", "Fun with JSON-B", "Alex Theedom");
        String actualJson = JsonbBuilder.create().toJson(book);
        assertThat(actualJson).contains("isbn");
    }

    @Test
    public void givenGetterAnnotateWithJsonbProperty_shouldChangeOfJsonProperty() {
        Book book = new Book("ABC-123-XYZ", "Fun with JSON-B", "Alex Theedom");
        String actualJson = JsonbBuilder.create().toJson(book);
        assertThat(actualJson).contains("bookTitle");
    }

    @Test
    public void givenSetterAnnotateWithJsonbProperty_shouldDeserialiseJsonProperty() {
        String json = "{\"authorName\":\"Alex Theedom\",\"bookTitle\":\"Fun with JSON-B\",\"isbn\":\"ABC-123-XYZ\"}";
        Book book = JsonbBuilder.create().fromJson(json, Book.class);
        assertThat(book.getAuthor()).contains("Alex Theedom");
    }

}