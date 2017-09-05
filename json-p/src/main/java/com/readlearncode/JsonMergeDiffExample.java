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
public class JsonMergeDiffExample extends JsonExample {

    public JsonMergePatch createMergePatch(){
        JsonValue source = Json.createValue("{\"colour\":\"blue\"}");
        JsonValue target = Json.createValue("{\"colour\":\"red\"}");
        JsonMergePatch jsonMergePatch = Json.createMergeDiff(source, target);
        return jsonMergePatch;
    }
}