package com.readlearncode.devWorks.overview;

import com.readlearncode.devWorks.overview.domain.Author;
import com.readlearncode.devWorks.overview.domain.Booklet;

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
    public JsonObject adaptToJson(Booklet booklet) throws Exception {
        return Json.createObjectBuilder()
                .add("title", booklet.getTitle())
                .add("firstName", booklet.getAuthor().getFirstName())
                .add("lastName", booklet.getAuthor().getLastName())
                .build();
    }

    @Override
    public Booklet adaptFromJson(JsonObject json) throws Exception {
        Booklet booklet = new Booklet("Fun with Java", "Alex", "Theedom");
        booklet.setTitle(json.getString("title"));
        booklet.setAuthor(new Author(json.getString("firstName"), json.getString("lastName")));
        return booklet;
    }
}