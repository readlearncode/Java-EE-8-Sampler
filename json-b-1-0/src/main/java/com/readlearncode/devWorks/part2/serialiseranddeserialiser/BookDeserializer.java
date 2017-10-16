package com.readlearncode.devWorks.part2.serialiseranddeserialiser;


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
public class BookDeserializer implements JsonbDeserializer<String> {

    @Override
    public String deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            if (event == JsonParser.Event.KEY_NAME) {
                String keyName = parser.getString();
                if (keyName.equals("id")) {
                    return ctx.deserialize(String.class, parser);
                }
            }
            parser.next();
        }
        return "";
    }
}
