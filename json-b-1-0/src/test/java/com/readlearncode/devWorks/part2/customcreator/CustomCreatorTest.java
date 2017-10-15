package com.readlearncode.devWorks.part2.customcreator;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CustomCreatorTest {

    @Test
    public void givenCustomCreatorFactoryMethod_shouldUseCustomCreator() {
        String json = "{\"author\":\"Alex Theedom\",\"title\":\"Fun with JSON-B\",\"id\":\"ABC-123-XYZ\"}";
        Book book = JsonbBuilder.create().fromJson(json, Book.class);
        assertThat(book.getId()).isEqualTo("ABC-123-XYZ");
        assertThat(book.getTitle()).isEqualTo("Fun with JSON-B");
        assertThat(book.getAuthor()).isEqualTo("Alex Theedom");
    }

    @Test
    public void givenCustomCreatorConstructor_shouldUseCustomCreator() {
        String json = "{\"surname\":\"Theedom\",\"bookTitle\":\"Fun with JSON-B\",\"firstName\":\"Alex\"}";
        Magazine magazine = JsonbBuilder.create().fromJson(json, Magazine.class);
        assertThat(magazine.getTitle()).isEqualTo("Fun with JSON-B");
        assertThat(magazine.getAuthorName().getFirstName()).isEqualTo("Alex");
        assertThat(magazine.getAuthorName().getLastName()).isEqualTo("Theedom");
    }

}