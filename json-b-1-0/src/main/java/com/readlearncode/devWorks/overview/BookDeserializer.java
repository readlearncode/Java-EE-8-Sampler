package com.readlearncode.devWorks.overview;

import com.readlearncode.devWorks.overview.domain.Book;

import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BookDeserializer implements JsonbDeserializer<Book> {

    @Override
    public Book deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        Book book = null;
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            if (event == JsonParser.Event.KEY_NAME) {
                String className = parser.getString();
                parser.next();
                try {
                    book = ctx.deserialize(Class.forName(className).asSubclass(Book.class), parser);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return book;
    }
}
