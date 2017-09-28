package com.readlearncode.devWorks.part2.treatementofnulls;

import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class NullsTest {

    private Jsonb jsonb = JsonbBuilder.create();

    @Test
    public void givenIntegerJSON_shouldDeserialiseToOptionalOfInteger() {

        String json = jsonb.toJson(new OptionalExample(null));

        assertThat(jsonb.fromJson(json, OptionalExample.class))
                .hasFieldOrPropertyWithValue("value", Optional.ofNullable(null));
    }


    @Test
    public void givenEmptyJson_shouldNotPreserveRoundTripEquivalence() {
        assertThat(
                jsonb.fromJson("{}", OptionalAndValueExample.class
                )
        ).hasFieldOrPropertyWithValue("value", null);
    }
}