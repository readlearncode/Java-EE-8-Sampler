package com.readlearncode;

import javax.json.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonPointerSimple {

    private JsonObject jsonObject = loadJsonObject();


    public JsonPointerSimple() throws IOException {
    }

    public String find() throws IOException {
        JsonPointer pointer = Json.createPointer("/topics/1");
        JsonString jsonValue = (JsonString) pointer.getValue(jsonObject);
        return jsonValue.getString();
    }

    public String replace() {
        JsonPointer pointer = Json.createPointer("/topics/1");
        JsonObject newJsonObject = pointer.replace(jsonObject, Json.createValue("Big Data"));
        JsonString jsonValue = (JsonString) pointer.getValue(newJsonObject);
        return jsonValue.getString();
    }

    private static JsonObject loadJsonObject() throws IOException {

        try (InputStream is = JsonPointerSimple.class.getResourceAsStream("/jsondata-object.json");
             JsonReader jsonReader = Json.createReader(is)) {
            return jsonReader.readObject();
        }

    }
}