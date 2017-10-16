package com.readlearncode.devWorks.part2.serialiseranddeserialiser;


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
        generator.writeStartObject();
        generator.write("id", "QWE-123-RTS");
        generator.write("title", book.getTitle());
        generator.write("firstName", book.getAuthor().split(" ")[0]);
        generator.write("lastName", book.getAuthor().split(" ")[1]);
        generator.writeEnd();
    }
}