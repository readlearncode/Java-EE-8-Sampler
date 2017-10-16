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
public class BookDeserializerTest {

    @Test
    public void givenJSON_shouldDeserializeToBook() {
        String json = "{\"id\":\"QWE-123-RTS\",\"lastName\":\"Theedom\",\"firstName\":\"Alex\",\"title\":\"Fun with Java\"}";
        JsonbConfig config = new JsonbConfig().withDeserializers(new BookDeserializer());
        Jsonb jsonb = JsonbBuilder.newBuilder().withConfig(config).build();
        String id = jsonb.fromJson(json, String.class);
        assertThat(id).isEqualTo("QWE-123-RTS");
    }

}