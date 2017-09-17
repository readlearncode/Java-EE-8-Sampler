package com.readlearncode.devWorks.overview;

import com.readlearncode.devWorks.overview.domain.Book;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BookSerializer implements JsonbSerializer<Book> {

    @Override
    public void serialize(Book book, JsonGenerator generator, SerializationContext ctx) {

        if (book != null) {
            generator.writeStartObject();
            ctx.serialize(book.getClass().getName(), book, generator);
            generator.writeEnd();
        } else {
            ctx.serialize(null, generator);
        }
    }
}