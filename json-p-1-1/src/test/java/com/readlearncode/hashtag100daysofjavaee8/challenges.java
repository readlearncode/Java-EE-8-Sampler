package com.readlearncode.hashtag100daysofjavaee8;

import org.junit.Ignore;
import org.junit.Test;

import javax.json.*;

import java.io.StringReader;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class challenges {

    @Test
    @Ignore
    public void givenTargetJSON_whenPatchIsApplied_shouldChangeResult() {

        JsonValue target = Json.createValue("{\"colour\":\"blue\",\"size\":10}");
        JsonValue patch = Json.createValue("{\"colour\":\"red\"}");
        JsonValue result = Json.createMergePatch(patch).apply(target);

        System.out.println(result);

        assertThat(((JsonString) result).getString()).isEqualToIgnoringCase("{\"colour\":\"red\"}");
    }


    @Test
    public void givenATarget_JSONPointerShouldFindValue() {

        /* Target JSON document
        {
          "name": "Duke",
          "likes": [
            "Java",
            "Coffee"
          ]
        }
         */

        String target = "{\"name\":\"Duke\",\"likes\":[\"Java\",\"Coffee\"]}";
        JsonObject jsonObject = Json.createReader(new StringReader(target)).readObject();
        JsonPointer pointer = Json.createPointer("/likes/0");
        jsonObject = pointer.add(jsonObject, Json.createValue("Java EE 8"));
        pointer = Json.createPointer("/likes/2");
        JsonObject newJsonObject = pointer.replace(jsonObject, Json.createValue("Ice Cream"));

        // What is the shape of the new JSON Object?

        assertThat(newJsonObject.toString()).isEqualToIgnoringCase("{\"name\":\"Duke\",\"likes\":[\"Java EE 8\",\"Java\",\"Ice Cream\"]}");
    }


}