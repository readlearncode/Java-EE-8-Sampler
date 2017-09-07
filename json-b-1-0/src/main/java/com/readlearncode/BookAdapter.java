package com.readlearncode;

import com.readlearncode.domain.Author;
import com.readlearncode.domain.Book;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BookAdapter implements JsonbAdapter<Book, JsonObject> {

    @Override
    public JsonObject adaptToJson(Book book) throws Exception {
        return Json.createObjectBuilder()
                .add("isbn", book.getId())
                .add("bookTitle", book.getTitle())
                .add("firstName", book.getAuthor().getFirstName())
                .add("lastName", book.getAuthor().getLastName())
                .build();
    }

    @Override
    public Book adaptFromJson(JsonObject json) throws Exception {
        Book book = new Book();
        book.setId(json.getString("isbn"));
        book.setTitle(json.getString("bookTitle"));
        book.setAuthor(new Author(json.getString("firstName"), json.getString("lastName")));
        return book;
    }
}