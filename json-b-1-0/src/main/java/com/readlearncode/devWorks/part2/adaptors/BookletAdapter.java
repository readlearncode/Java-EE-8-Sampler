package com.readlearncode.devWorks.part2.adaptors;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BookletAdapter implements JsonbAdapter<Booklet, JsonObject> {

    @Override
    public JsonObject adaptToJson(Booklet booklet) {
        return Json.createObjectBuilder()
                .add("title", booklet.getTitle())
                .add("firstName", booklet.getAuthor().getFirstName())
                .add("lastName", booklet.getAuthor().getLastName())
                .build();
    }

    @Override
    public Booklet adaptFromJson(JsonObject json) {
        Booklet booklet = new Booklet(
                json.getString("title"),
                new Author(json.getString("firstName"), json.getString("lastName")));
        return booklet;
    }
}