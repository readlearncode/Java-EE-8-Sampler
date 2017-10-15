package com.readlearncode.devWorks.part1.overloaded;

import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class FromJsonExampleTest {

    private Jsonb jsonb = JsonbBuilder.create();
    private String json = "{\"author\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"binding\":\"SOFT_BACK\",\"id\":\"1234567890\",\"inPrint\":true,\"languages\":[\"English\",\"Polish\",\"Russian\",\"Chinese\"],\"pages\":300,\"price\":25.0,\"title\":\"Fun with Java EE\"}";
    private Book expectedBook = new Book();

    {
        Author alex = new Author("Alex", "Theedom");

        expectedBook.setId("1234567890");
        expectedBook.setAuthor(alex);
        expectedBook.setTitle("Fun with Java EE");
        expectedBook.setPrice(25.00F);
        expectedBook.setInPrint(true);
        expectedBook.setPages(300);
        expectedBook.setBinding(Binding.SOFT_BACK);
        expectedBook.setLanguages(new ArrayList<String>() {{
            add("English");
            add("Polish");
            add("Russian");
            add("Chinese");
        }});
    }


    @Test
    public void givenBookJson_whenCallingFromJson_shouldOutputBookObject() {
        Book actualBook = jsonb.fromJson(json, Book.class);
        assertThat(actualBook).isEqualTo(expectedBook);
    }

    @Test
    public void givenBookJsonInFile_whenCallingFromJson_shouldOutputBookObject() throws FileNotFoundException {

        FileReader fileReader = new FileReader("book.json");

        Book actualBook = jsonb.fromJson(new FileInputStream("book.json"), Book.class);
        assertThat(actualBook).isEqualTo(expectedBook);
    }


}