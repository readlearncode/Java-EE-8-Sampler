package com.readlearncode.devWorks.part2.dateandnumberformat;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.JsonbException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CustomiseDateFormatTest {

    @Test
    public void givenDateInJsonDocument_shouldThrowException() {
        String json = "{\"published\":\"10/10/2018\",\"author\":\"Alex Theedom\",\"title\":\"Fun with JSON-B\",\"id\":\"ABC-123-XYZ\"}";
        assertThatThrownBy(() ->
                JsonbBuilder.create().fromJson(json, Book.class)
        ).isInstanceOf(JsonbException.class)
                .hasMessageContaining("Error parsing date from value: 10/10/2018");
    }

    @Test
    public void givenDateInJsonDocument_whenDateFormatConfigured_shouldDeserialise() {
        String json = "{\"published\":\"10/10/2018\",\"author\":\"Alex Theedom\",\"title\":\"Fun with JSON-B\"}";
        JsonbConfig jsonbConfig = new JsonbConfig().withDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Book book = JsonbBuilder.create(jsonbConfig).fromJson(json, Book.class);
        assertThat(book.getPublished()).isEqualTo(LocalDate.of(2018, Month.OCTOBER, 10));
    }

    @Test
    public void givenDateInJsonDocument_whenJsonbDateFormat_shouldDeserialise() {
        String json = "{\"authorName\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"published\":\"10/10/2018\",\"title\":\"Fun with JSON Binding\"}";
        Magazine magazine = JsonbBuilder.create().fromJson(json, Magazine.class);
        assertThat(magazine.getPublished()).isEqualTo(LocalDate.of(2018, Month.OCTOBER, 10));
    }


}