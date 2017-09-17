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
public class BookDeserializerTest {

    @Test
    public void givenJSON_shouldDeserializeToBook() {
        Book expectedBook = new Book("SHDUJ-4532", "Fun with Java", "Alex Theedom");
        String json = "{\"com.readlearncode.devWorks.overview.domain.Book\":{\"author\":\"Alex Theedom\",\"id\":\"SHDUJ-4532\",\"title\":\"Fun with Java\"}}";
        JsonbConfig config = new JsonbConfig().withDeserializers(new BookDeserializer());
        Jsonb jsonb = JsonbBuilder.newBuilder().withConfig(config).build();
        Book actualBook = jsonb.fromJson(json, Book.class);

        assertThat(actualBook).isEqualTo(expectedBook);
    }

}