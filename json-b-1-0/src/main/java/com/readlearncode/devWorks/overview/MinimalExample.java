package com.readlearncode.devWorks.overview;

import com.readlearncode.devWorks.overview.domain.Book;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class MinimalExample {

    public String serializeBook() {
        Book book = new Book("SHDUJ-4532", "Fun with Java", "Alex Theedom");
        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(book);
        return json;
    }

    public Book deserializeBook() {
        Book book = new Book("SHDUJ-4532", "Fun with Java", "Alex Theedom");
        Jsonb jsonb = JsonbBuilder.create();
        String json = jsonb.toJson(book);
        book = jsonb.fromJson(json, Book.class);
        return book;
    }
}