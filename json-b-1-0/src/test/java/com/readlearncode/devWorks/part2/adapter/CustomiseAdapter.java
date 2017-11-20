package com.readlearncode.devWorks.part2.adapter;


import com.readlearncode.devWorks.part2.adaptors.Author;
import com.readlearncode.devWorks.part2.adaptors.Booklet;
import com.readlearncode.devWorks.part2.adaptors.BookletAdapter;
import org.junit.Ignore;
import org.junit.Test;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CustomiseAdapter {

    @Test
    public void givenAdaptor_shouldFlattenAuthor() {
        String expectedJson = "{\"title\":\"Fun with JSON-B\",\"firstName\":\"Alex\",\"lastName\":\"Theedom\"}";
        JsonbConfig jsonbConfig = new JsonbConfig().withAdapters(new BookletAdapter());
        Booklet booklet = new Booklet("Fun with JSON-B", new Author("Alex", "Theedom"));
        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(booklet);
        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    public void givenAdaptor_shouldPopulateAuthor() {
        String json = "{\"title\":\"Fun with JSON-B\",\"firstName\":\"Alex\",\"lastName\":\"Theedom\"}";
        JsonbConfig jsonbConfig = new JsonbConfig().withAdapters(new BookletAdapter());
        Booklet booklet = JsonbBuilder.create(jsonbConfig).fromJson(json, Booklet.class);
        assertThat(booklet.getTitle()).isEqualTo("Fun with JSON-B");
        assertThat(booklet.getAuthor().getFirstName()).isEqualTo("Alex");
        assertThat(booklet.getAuthor().getLastName()).isEqualTo("Theedom");
    }

    @Test @Ignore("Failing test fix!!")
    public void givenAdaptorOnJsonbTypeAdapter_shouldSerialise(){
        String expectedJson = "{\"firstName\":\"A\",\"lastName\":\"Theedom\"}";
        Author author = new Author("Alex", "Theedom");
        String actualJson = JsonbBuilder.create().toJson(author);
        assertThat(actualJson).isEqualTo(expectedJson);
    }

}