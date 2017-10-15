package com.readlearncode.devWorks.part2.visibility;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonbTransientTest {

    @Test
    public void whenIDFieldIsAnnotatedJsonbTransient_shouldNotBeSerialised(){

        Book book = new Book("ABC-123-XYZ", "Fun with JSON-B", "Alex Theedom");
        String actualJson = JsonbBuilder.create().toJson(book);
        assertThat(actualJson).doesNotContain("id");

    }
}