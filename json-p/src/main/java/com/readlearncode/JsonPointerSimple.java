package com.readlearncode;

import org.glassfish.json.JsonPointerImpl;

import javax.json.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonPointerSimple{

    public String findName() throws IOException {

        JsonPointer pointer = new JsonPointerImpl("/0/name");
        JsonValue jsonValue = pointer.getValue(loadJsonObject());
        return jsonValue.toString();

    }

    private static JsonStructure loadJsonObject() throws IOException {

        try (InputStream is = JsonPointerSimple.class.getResourceAsStream("/jsondata-object.json");
             JsonReader jsonReader = Json.createReader(is)) {
            return jsonReader.readArray();
        }

    }
}