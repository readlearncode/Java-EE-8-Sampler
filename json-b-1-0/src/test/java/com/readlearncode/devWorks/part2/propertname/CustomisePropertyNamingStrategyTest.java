package com.readlearncode.devWorks.part2.propertname;

import org.junit.Before;
import org.junit.Test;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.config.PropertyNamingStrategy;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CustomisePropertyNamingStrategyTest {

    private Magazine magazine;

    @Before
    public void setUp() {
        magazine = new Magazine("Fun with JSON binding", new Author("Alex", "Theedom"), "ABC-123", "Fun with JSON-B");
    }

    @Test
    public void givenIDENTITYStrategy_shouldNotChangeAnyPropertyName() {
        /*
            {
              "alternativetitle": "Fun with JSON-B",
              "authorName": {
                "firstName": "Alex",
                "lastName": "Theedom"
              },
              "title": "Fun with JSON binding"
            }
         */

        String expectedJson = "{\"alternativetitle\":\"Fun with JSON-B\",\"authorName\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"title\":\"Fun with JSON binding\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyNamingStrategy(PropertyNamingStrategy.IDENTITY);

        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(magazine);

        assertThat(actualJson).isEqualTo(expectedJson);
    }


    @Test
    public void givenLOWER_CASE_WITH_DASHESStrategy_shouldDelimitPropertyNameWithDashes() {
        /*
            {
              "alternativetitle": "Fun with JSON-B",
              "author-name": {
                "first-name": "Alex",
                "last-name": "Theedom"
              },
              "title": "Fun with JSON binding"
            }
         */

        String expectedJson = "{\"alternativetitle\":\"Fun with JSON-B\",\"author-name\":{\"first-name\":\"Alex\",\"last-name\":\"Theedom\"},\"title\":\"Fun with JSON binding\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);

        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(magazine);

        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    public void givenLOWER_CASE_WITH_DASHESStrategy_shouldDeserialiseCorrectly() {
        /*
            {
              "alternativetitle": "Fun with JSON-B",
              "author-name": {
                "first-name": "Alex",
                "last-name": "Theedom"
              },
              "title": "Fun with JSON binding"
            }
         */

        String expectedJson = "{\"alternativetitle\":\"Fun with JSON-B\",\"author-name\":{\"first-name\":\"Alex\",\"last-name\":\"Theedom\"},\"title\":\"Fun with JSON binding\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);

        Magazine magazine = JsonbBuilder.create(jsonbConfig).fromJson(expectedJson, Magazine.class);

        assertThat(magazine.getAlternativetitle()).isEqualTo("Fun with JSON-B");
        assertThat(magazine.getAuthorName().getFirstName()).isEqualTo("Alex");
        assertThat(magazine.getAuthorName().getLastName()).isEqualTo("Theedom");
        assertThat(magazine.getTitle()).isEqualTo("Fun with JSON binding");
    }

    @Test
    public void givenLOWER_CASE_WITH_UNDERSCORESStrategy_shouldDelimitLowercasePropertyNameWithUnderscore() {
        /*
            {
              "alternativetitle": "Fun with JSON-B",
              "author_name": {
                "first_name": "Alex",
                "last_name": "Theedom"
              },
              "title": "Fun with JSON binding"
            }
         */

        String expectedJson = "{\"alternativetitle\":\"Fun with JSON-B\",\"author_name\":{\"first_name\":\"Alex\",\"last_name\":\"Theedom\"},\"title\":\"Fun with JSON binding\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_UNDERSCORES);

        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(magazine);

        assertThat(actualJson).isEqualTo(expectedJson);
    }


    @Test
    public void givenUPPER_CAMEL_CASEStrategy_shouldDelimitLowercasePropertyNameWithUnderscore() {
        /*
            {
              "Alternativetitle": "Fun with JSON-B",
              "AuthorName": {
                "FirstName": "Alex",
                "LastName": "Theedom"
              },
              "Title": "Fun with JSON binding"
            }
         */

        String expectedJson = "{\"Alternativetitle\":\"Fun with JSON-B\",\"AuthorName\":{\"FirstName\":\"Alex\",\"LastName\":\"Theedom\"},\"Title\":\"Fun with JSON binding\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);

        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(magazine);

        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    public void givenUPPER_CAMEL_CASE_WITH_SPACESStrategy_shouldDelimitLowercasePropertyNameWithUnderscore() {
        /*
            {
              "Alternativetitle": "Fun with JSON-B",
              "Author Name": {
                "First Name": "Alex",
                "Last Name": "Theedom"
              },
              "Title": "Fun with JSON binding"
            }
         */

        String expectedJson = "{\"Alternativetitle\":\"Fun with JSON-B\",\"Author Name\":{\"First Name\":\"Alex\",\"Last Name\":\"Theedom\"},\"Title\":\"Fun with JSON binding\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE_WITH_SPACES);

        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(magazine);

        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    public void givenCASE_INSENSITIVEStrategy_shouldDelimitLowercasePropertyNameWithUnderscore() {
        /*
            {
              "alternativetitle": "Fun with JSON-B",
              "authorName": {
                "firstName": "Alex",
                "lastName": "Theedom"
              },
              "title": "Fun with JSON binding"
            }
         */

        String expectedJson = "{\"alternativetitle\":\"Fun with JSON-B\",\"authorName\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"title\":\"Fun with JSON binding\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyNamingStrategy(PropertyNamingStrategy.CASE_INSENSITIVE);

        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(magazine);

        assertThat(actualJson).isEqualTo(expectedJson);
    }

    public class Person {
        @JsonbProperty("name")
         public String authorName;
    }

    @Test
    public void givenPropertyNameStrategyAndJsonbProperty_JsonbPropertyShouldHavePrecedence() {
        String expectedJson = "{\"name\":\"Alex Theedom\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_UNDERSCORES);

        Person person = new Person();
        person.authorName = "Alex Theedom";
        String json = JsonbBuilder.create(jsonbConfig).toJson(person);

        assertThat(expectedJson).isEqualTo(json);
    }


}