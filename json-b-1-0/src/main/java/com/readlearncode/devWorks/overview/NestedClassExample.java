package com.readlearncode.devWorks.overview;

import com.readlearncode.devWorks.overview.domain.OuterClass;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class NestedClassExample {

    public String serializeNestedClasses() {

        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();

        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(innerClass);

        return json;
    }

    public OuterClass.InnerClass deserialiseNestedClasses() {

        String json = "{\"name\":\"Inner Class\"}";

        OuterClass.InnerClass innerClass =
                JsonbBuilder.create().fromJson(json, OuterClass.InnerClass.class);

        return innerClass;
    }
}