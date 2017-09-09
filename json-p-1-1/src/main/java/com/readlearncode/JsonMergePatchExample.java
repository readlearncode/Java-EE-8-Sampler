package com.readlearncode;

import javax.json.Json;
import javax.json.JsonMergePatch;
import javax.json.JsonValue;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonMergePatchExample extends JsonExample {

    public JsonValue changeValue() {
        JsonValue source = Json.createValue("{\"colour\":\"blue\"}");
        JsonValue patch = Json.createValue("{\"colour\":\"red\"}");
        JsonMergePatch jsonMergePatch = Json.createMergePatch(patch);


        Json.createMergePatch(Json.createValue("{\"colour\":\"red\"}")).apply(Json.createValue("{\"colour\":\"red\"}"));


        return jsonMergePatch.apply(source);
    }

    public JsonValue addValue() {
        JsonValue source = Json.createValue("{\"colour\":\"blue\"}");
        JsonValue patch = Json.createValue("{\"blue\":\"light\"}");
        JsonMergePatch jsonMergePatch = Json.createMergePatch(patch);
        return jsonMergePatch.apply(source);
    }

    public JsonValue deleteValue() {
        JsonValue source = Json.createValue("{\"colour\":\"blue\"}");
        JsonValue patch = Json.createValue("{\"colour\":null}");
        JsonMergePatch jsonMergePatch = Json.createMergePatch(patch);
        return jsonMergePatch.apply(source);
    }

}