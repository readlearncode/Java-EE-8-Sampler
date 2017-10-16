package com.readlearncode.devWorks.part2.miscellaneous;


import org.junit.Test;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.util.Locale;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class MiscellaneousTest {

    @Test
    public void characterEncoding(){
        JsonbConfig jsonbConfig = new JsonbConfig().withEncoding("UTF-32");
    }

    @Test
    public void local(){
        JsonbConfig jsonbConfig = new JsonbConfig().withLocale(Locale.CANADA);
    }

    @Test
    public void prettyJsonFormat(){
        JsonbConfig jsonbConfig = new JsonbConfig().withFormatting(true);
        Book book = new Book("ABC-123-XYZ", "Fun with JSON-B", "Alex Theedom");
        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(book);
        System.out.println(actualJson);
    }

}