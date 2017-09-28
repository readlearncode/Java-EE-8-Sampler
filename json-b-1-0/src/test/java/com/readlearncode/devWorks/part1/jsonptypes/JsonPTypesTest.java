package com.readlearncode.devWorks.part1.jsonptypes;

import org.junit.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonPTypesTest {

    private Jsonb jsonb = JsonbBuilder.create();

    @Test
    public void givenJsonArray_shouldSerialiseToJsonArray() {

        String expectedJson = "[\"John\",null]";

        JsonArray value = Json.createArrayBuilder()
                .add(Json.createValue("John"))
                .add(JsonValue.NULL)
                .build();

        String actualJson = jsonb.toJson(value);

        assertThat(actualJson).isEqualTo(expectedJson);
    }


}