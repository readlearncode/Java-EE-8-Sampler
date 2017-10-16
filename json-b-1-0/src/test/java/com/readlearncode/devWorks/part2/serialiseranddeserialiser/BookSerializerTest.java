package com.readlearncode.devWorks.part2.serialiseranddeserialiser;

import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BookSerializerTest {

    @Test
    public void givenSerialize_shouldSerialiseBook() {
        Book book = new Book("SHDUJ-4532", "Fun with Java", "Alex Theedom");
        String expectedJson = "{\"id\":\"QWE-123-RTS\",\"title\":\"Fun with Java\",\"firstName\":\"Alex\",\"lastName\":\"Theedom\"}";
        JsonbConfig config = new JsonbConfig().withSerializers(new BookSerializer());
        Jsonb jsonb = JsonbBuilder.newBuilder().withConfig(config).build();
        String actualJson = jsonb.toJson(book);

        assertThat(actualJson).isEqualTo(expectedJson);
    }

}