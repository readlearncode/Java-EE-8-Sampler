package com.readlearncode.devWorks.part2.adaptors;

import javax.json.Json;
import javax.json.JsonValue;
import javax.json.bind.adapter.JsonbAdapter;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class FirstNameAdapter implements JsonbAdapter<String, JsonValue> {

    @Override
    public JsonValue adaptToJson(String firstName) {
        return Json.createValue(firstName.subSequence(0,1).toString());
    }

    @Override
    public String adaptFromJson(JsonValue json) {
        return json.toString();
    }
}