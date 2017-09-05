package com.readlearncode;

import org.junit.Test;

import javax.json.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonPatchExampleTest {

    @Test
    public void ifValueIsMoved_shouldNotAmendOriginalJSON() {
        JsonPatchExample jsonPatchExample = new JsonPatchExample();
        JsonObject jsonObject = jsonPatchExample.toJsonArray();

        JsonPointer pointer = Json.createPointer("/series/0");
        JsonString jsonString = (JsonString) pointer.getValue(jsonObject);
        assertThat(jsonString.getString()).isEqualToIgnoringCase("Cognitive");
    }

    @Test
    public void ifValueExists_moveItToDestination() {
        JsonPatchExample jsonPatchExample = new JsonPatchExample();
        JsonObject jsonObject = jsonPatchExample.test();

        JsonPointer pointer = Json.createPointer("/series/2");
        JsonString jsonString = (JsonString) pointer.getValue(jsonObject);
        assertThat(jsonString.getString()).isEqualToIgnoringCase("Data");
    }

    @Test
    public void givenPath_copyToTargetPath() throws Exception {
        JsonPatchExample jsonPatchExample = new JsonPatchExample();
        JsonObject jsonObject = jsonPatchExample.copy();

        JsonPointer pointer = Json.createPointer("/series/0");
        JsonString jsonString = (JsonString) pointer.getValue(jsonObject);
        assertThat(jsonString.getString()).isEqualToIgnoringCase("Cognitive");
    }

    @Test
    public void givenPath_moveToTargetPath() throws Exception {
        JsonPatchExample jsonPatchExample = new JsonPatchExample();
        JsonObject jsonObject = jsonPatchExample.move();

        JsonPointer pointer = Json.createPointer("/series/0");
        JsonString jsonString = (JsonString) pointer.getValue(jsonObject);
        assertThat(jsonString.getString()).isEqualToIgnoringCase("Cognitive");
    }

    @Test
    public void givenPatchPath_shouldRemoveAndAdd() {
        JsonPatchExample jsonPatchExample = new JsonPatchExample();
        JsonObject jsonObject = jsonPatchExample.addAndRemove();

        // Assert that "comments" property was added with value "Very Good!"
        JsonPointer pointer = Json.createPointer("/comments");
        JsonValue jsonValue = pointer.getValue(jsonObject);
        assertThat(jsonValue.getValueType()).isEqualTo(JsonValue.ValueType.ARRAY);
        assertThat(jsonValue.asJsonArray().contains(Json.createValue("Very Good!"))).isTrue();
        assertThat(jsonValue.asJsonArray().contains(Json.createValue("Excellent"))).isTrue();

        // Assert that "notes" property was removed
        pointer = Json.createPointer("/notes");
        boolean contains = pointer.containsValue(jsonObject);
        assertThat(contains).isFalse();
    }

    @Test
    public void givenPatchPath_shouldReplaceElement() {
        JsonPatchExample jsonPatchExample = new JsonPatchExample();
        String series = jsonPatchExample.replace();
        assertThat(series).isEqualToIgnoringCase("Spring 5");
    }

}