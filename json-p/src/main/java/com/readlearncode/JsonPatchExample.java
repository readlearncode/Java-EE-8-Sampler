package com.readlearncode;

import javax.json.*;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonPatchExample extends JsonExample {

    private JsonObject jsonObject = loadJsonObject();

    public String replace() {
        JsonPatchBuilder builder = Json.createPatchBuilder();
        JsonPatch jsonPatch = builder.replace("/series/0", "Spring 5").build();
        JsonObject newJsonObject = jsonPatch.apply(jsonObject);

        JsonPointer pointer = Json.createPointer("/series/0");
        JsonString jsonValue = (JsonString) pointer.getValue(newJsonObject);
        return jsonValue.getString();
    }

    public JsonObject addAndRemove() {
        JsonPatchBuilder builder = Json.createPatchBuilder();
        JsonPatch jsonPatch = builder
                .add("/comments", Json.createArrayBuilder().add("Very Good!").add("Excellent").build())
                .remove("/notes")
                .build();

        return jsonPatch.apply(jsonObject);
    }

    public JsonObject move() {
        JsonPatchBuilder builder = Json.createPatchBuilder();
        JsonPatch jsonPatch = builder.move("/series/0", "/topics/0").build(); // destination, source
        return jsonPatch.apply(jsonObject);
    }

    public JsonObject copy() {
        JsonPatchBuilder builder = Json.createPatchBuilder();
        JsonPatch jsonPatch = builder.copy("/series/0", "/topics/0").build(); // destination, source
        return jsonPatch.apply(jsonObject);
    }

    public JsonObject test() {
        JsonPatchBuilder builder = Json.createPatchBuilder();
        JsonPatch jsonPatch = builder
                .test("/topics/2", "Data")
                .move("/series/2", "/topics/2")
                .build();
        return jsonPatch.apply(jsonObject);
    }

    public JsonObject toJsonArray() {
        JsonPatchBuilder builder = Json.createPatchBuilder();
        JsonArray jsonArray = builder.copy("/series/0", "/topics/0").build().toJsonArray(); // destination, source
        return Json.createPatchBuilder(jsonArray).build().apply(jsonObject);
    }

}