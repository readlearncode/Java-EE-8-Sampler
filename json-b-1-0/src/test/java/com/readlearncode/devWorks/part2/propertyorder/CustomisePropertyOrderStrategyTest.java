package com.readlearncode.devWorks.part2.propertyorder;

import org.junit.Before;
import org.junit.Test;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyOrderStrategy;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CustomisePropertyOrderStrategyTest {

    private Magazine magazine;

    @Before
    public void setUp() {
        magazine = new Magazine("Fun with JSON binding", new Author("Alex", "Theedom"), "01846537");
    }

    @Test
    public void givenJsonbPropertyOrderSet_shouldOrderProperties() {
        /*
            {
              "id": "ABC-123-XYZ",
              "title": "Fun with JSON-B",
              "author": "Alex Theedom"
            }
         */

        String expectedJson = "{\"id\":\"ABC-123-XYZ\",\"title\":\"Fun with JSON-B\",\"author\":\"Alex Theedom\"}";
        Book book = new Book("ABC-123-XYZ", "Fun with JSON-B", "Alex Theedom");

        String actualJson = JsonbBuilder.create().toJson(book);

        assertThat(expectedJson).isEqualTo(actualJson);
    }


    @Test
    public void givenLEXICOGRAPHICALPropertyOrderStrategy_shouldOrderLexicographically(){

        String expectedJson = "{\"alternativeTitle\":\"01846537\",\"authorName\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"title\":\"Fun with JSON binding\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyOrderStrategy(PropertyOrderStrategy.LEXICOGRAPHICAL);

        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(magazine);

        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    public void givenANYPropertyOrderStrategy_shouldOrderLexicographically(){

        String expectedJson = "{\"authorName\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"alternativeTitle\":\"01846537\",\"title\":\"Fun with JSON binding\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyOrderStrategy(PropertyOrderStrategy.ANY);

        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(magazine);

        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    public void givenREVERSEPropertyOrderStrategy_shouldOrderLexicographically(){

        String expectedJson = "{\"title\":\"Fun with JSON binding\",\"authorName\":{\"lastName\":\"Theedom\",\"firstName\":\"Alex\"},\"alternativeTitle\":\"01846537\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyOrderStrategy(PropertyOrderStrategy.REVERSE);

        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(magazine);

        assertThat(actualJson).isEqualTo(expectedJson);
    }






}