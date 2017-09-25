package com.readlearncode.devWorks.part1.overloaded;

import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ToJsonExamples {

    private Jsonb jsonb = JsonbBuilder.create();
    private String expectedJson = "{\"author\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"binding\":\"SOFT_BACK\",\"id\":\"1234567890\",\"inPrint\":true,\"languages\":[\"English\",\"Polish\",\"Russian\",\"Chinese\"],\"pages\":300,\"price\":25.0,\"title\":\"Fun with Java EE\"}";
    private Book book = new Book();

    {
        Author alex = new Author("Alex", "Theedom");

        book.setId("1234567890");
        book.setAuthor(alex);
        book.setTitle("Fun with Java EE");
        book.setPrice(25.00F);
        book.setInPrint(true);
        book.setPages(300);
        book.setBinding(Binding.SOFT_BACK);
        book.setLanguages(new ArrayList<String>() {{
            add("English");
            add("Polish");
            add("Russian");
            add("Chinese");
        }});
    }

    @Test
    public void givenBookObject_whenCallingToJson_shouldOutputString() {
        String actualJson = jsonb.toJson(book);
        assertThat(actualJson).isInstanceOf(String.class);
        assertThat(actualJson).isEqualTo(expectedJson);

       /*
        {
          "author": {
            "firstName": "Alex",
            "lastName": "Theedom"
          },
          "binding": "SOFT_BACK",
          "id": "1234567890",
          "inPrint": true,
          "languages": [
            "English",
            "Polish",
            "Russian",
            "Chinese"
          ],
          "pages": 300,
          "price": 25,
          "title": "Fun with Java EE"
        }
       */
    }


    @Test
    public void givenBookObject_whenCallingToJson_shouldOutputToOutputStream() throws IOException {

        jsonb.toJson(book, new FileOutputStream("book.json"));

        String actualJson = new String(Files.readAllBytes(FileSystems.getDefault().getPath("book.json")));

        assertThat(actualJson).isEqualTo(expectedJson);
    }



}