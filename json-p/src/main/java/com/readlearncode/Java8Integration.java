package com.readlearncode;

import javax.json.JsonObject;
import javax.json.JsonString;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Java8Integration extends JsonExample {

    private JsonObject jsonObject = loadJsonObject();

    public List<String> filterJsonArray() {
        List<String> topics = jsonObject.getJsonArray("topics").stream()
                .filter(jsonValue -> ((JsonString) jsonValue).getString().startsWith("C"))
                .map(jsonValue -> ((JsonString) jsonValue).getString())
                .collect(Collectors.toList());
        return topics;
    }

}