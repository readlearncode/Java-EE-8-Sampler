package com.readlearncode.devWorks.overview;

import com.readlearncode.devWorks.overview.domain.Magazine;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class MagazineSerializer implements JsonbSerializer<Magazine> {

    @Override
    public void serialize(Magazine magazine, JsonGenerator generator, SerializationContext ctx) {

        if (magazine != null) {
            generator.writeStartObject();
            ctx.serialize("name", magazine.getAuthor(), generator);
            generator.writeEnd();
        } else {
            ctx.serialize(null, generator);
        }

    }
}