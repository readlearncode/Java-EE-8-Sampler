package com.readlearncode;

import com.readlearncode.domain.Book;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import javax.json.bind.config.PropertyOrderStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class MapJsonToObject extends JsonExample {

    public String serializeBook() {
        return JsonbBuilder.create().toJson(book1);
    }

    public Book deserializeBook() {
        return JsonbBuilder.create().fromJson(bookJson, Book.class);
    }

    public String serializeListOfBooks() {
        return JsonbBuilder.create().toJson(books);
    }

    public List<Book> deserializeListOfBooks() {
        return JsonbBuilder.create().fromJson(bookListJson, new ArrayList<Book>().getClass().getGenericSuperclass());
    }

    public String customizedMapping() {

        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES)
                .withPropertyOrderStrategy(PropertyOrderStrategy.LEXICOGRAPHICAL)
                .withStrictIJSON(true)
                .withFormatting(true)
                .withNullValues(true);

        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);

        return jsonb.toJson(book1);
    }

    public String annotationMapping(){
        return JsonbBuilder.create().toJson(magazine);
    }

    public String bookAdapterToJson(){
        JsonbConfig jsonbConfig = new JsonbConfig().withAdapters(new BookAdapter());
        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);
        return jsonb.toJson(book1);
    }

    public Book bookAdapterToBook(){
        JsonbConfig jsonbConfig = new JsonbConfig().withAdapters(new BookAdapter());
        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);
        String json = "{\"isbn\":\"1234567890\",\"bookTitle\":\"Professional Java EE Design Patterns\",\"firstName\":\"Alex\",\"lastName\":\"Theedom\"}";
        return jsonb.fromJson(json, Book.class);
    }
}