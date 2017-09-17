package com.readlearncode.devWorks.overview;

import com.readlearncode.devWorks.overview.domain.Book;
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
    public void givenSerialize_shouldSerialiseBook()   {
        Book book = new Book("SHDUJ-4532", "Fun with Java", "Alex Theedom");
        String expectedJson = "{\"com.readlearncode.devWorks.overview.domain.Book\":{\"author\":\"Alex Theedom\",\"id\":\"SHDUJ-4532\",\"title\":\"Fun with Java\"}}";
        JsonbConfig config = new JsonbConfig().withSerializers(new BookSerializer());
        Jsonb jsonb = JsonbBuilder.newBuilder().withConfig(config).build();
        String actualJson = jsonb.toJson(book);

        assertThat(actualJson).isEqualTo(expectedJson);
    }

}