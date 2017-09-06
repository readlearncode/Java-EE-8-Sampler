package com.readlearncode;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonExample {

    public static JsonObject loadJsonObject() {
        try (InputStream is = JsonPointerExample.class.getResourceAsStream("/jsondata-object.json");
             JsonReader jsonReader = Json.createReader(is)) {
            return jsonReader.readObject();
        } catch (IOException e) {
            return null;
        }
    }

}