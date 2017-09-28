package com.readlearncode.devWorks.part1.javatypes;

import org.junit.Ignore;
import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class StandardTypeExampleTest {

    private Jsonb jsonb = JsonbBuilder.create();

    @Test
    public void givenBigInteger_shouldPreserveRoundTripEquivalence() {
        jsonb.fromJson(
                jsonb.toJson(new BigIntegerExample()), BigIntegerExample.class);
    }

    @Test
    public void givenOptionalOfAnInteger_shouldSerialiseToInteger() {
        assertThat(jsonb.toJson(new OptionalExample(10))).isEqualTo("{\"value\":10}");
    }

    @Test
    public void givenOptionalOfInteger_shouldSerialiseToJSONNumber() {
        assertThat(
                jsonb.toJson(Optional.of(Integer.valueOf(10))
                )
        ).isEqualTo("10");
    }

    @Test
    public void givenOptionalIntOfInteger_shouldSerialiseToInteger() {
        assertThat(jsonb.toJson(new OptionalIntExample(10))).isEqualTo("{\"value\":10}");
    }

    @Test
    public void givenOptionalLongOfLong_shouldSerialiseToLong() {
        assertThat(jsonb.toJson(new OptionalLongExample(10L))).isEqualTo("{\"value\":10}");
    }

    @Test
    public void givenOptionalDoubleOfDouble_shouldSerialiseToDouble() {
        assertThat(jsonb.toJson(new OptionalDoubleExample(10D))).isEqualTo("{\"value\":10.0}");
    }

    @Test
    public void givenEmptyOptional_shouldSerialiseToEmptyJson() {
        assertThat(jsonb.toJson(new EmptyOptionalExample(null))).isEqualTo("{}");
    }

    @Test
    public void givenEmptyJson_shouldNotPreserveRoundTripEquivalence() {
        // Nulls are not preserved on serialisation without customisation.
        // Note: the setter for value is not called. So the default of value is used.
        assertThat(
                jsonb.fromJson("{}", EmptyOptionalDefaultValueExample.class)
        ).hasFieldOrPropertyWithValue("value", Optional.of(10));
    }

    @Test
    public void givenEmptyJson_shouldProduceNullValue() {
        assertThat(
                jsonb.fromJson("{}", EmptyOptionalExample.class
                )
        ).hasFieldOrPropertyWithValue("value", null);
    }


    @Test
    public void givenNullJsonValue_shouldDeserialiseToOptionalEmpty() {
        assertThat(
                jsonb.fromJson(
                        "{\"value\": null}", EmptyOptionalExample.class
                )
        ).hasFieldOrPropertyWithValue("value", Optional.empty());
    }

    @Test
    public void givenIntegerJSON_shouldDeserialiseToOptionalInt() {
        assertThat(jsonb.fromJson("{\"value\":10}", OptionalIntExample.class))
                .hasFieldOrPropertyWithValue("value", OptionalInt.of(10));
    }

    @Test
    public void givenIntegerJSON_shouldDeserialiseToOptionalOfInteger() {
        assertThat(jsonb.fromJson("{\"value\":10}", OptionalExample.class))
                .hasFieldOrPropertyWithValue("value", Optional.of(10));
    }

    @Test @Ignore
    public void givenEnum_shouldSerialiseAsName() {


        List<Binding> bindings = new ArrayList<>();
        bindings.add(Binding.HARD_BACK);


        String expectedJson = "[\"HARD_BACK\"]";
        String actualJson = jsonb.toJson(bindings);

        assertThat(actualJson).isEqualTo(expectedJson);


    }

}