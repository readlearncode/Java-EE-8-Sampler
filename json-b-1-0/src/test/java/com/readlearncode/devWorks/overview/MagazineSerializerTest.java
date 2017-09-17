package com.readlearncode.devWorks.overview;

import com.readlearncode.devWorks.overview.domain.Author;
import com.readlearncode.devWorks.overview.domain.Magazine;
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
public class MagazineSerializerTest {

    @Test
    public void givenSerialize_shouldSerialiseMagazine() {

        Magazine magazine = new Magazine();
        magazine.setId("1234-QWERT");
        magazine.setTitle("Fun with Java");
        magazine.setAuthor(new Author("Alex","Theedom"));

        String expectedJson = "{\"name\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"}}";

        JsonbConfig config = new JsonbConfig().withSerializers(new MagazineSerializer());
        Jsonb jsonb = JsonbBuilder.newBuilder().withConfig(config).build();
        String actualJson = jsonb.toJson(magazine);
        assertThat(actualJson).isEqualTo(expectedJson);

    }

}