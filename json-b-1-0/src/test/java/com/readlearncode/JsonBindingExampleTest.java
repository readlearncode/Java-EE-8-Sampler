package com.readlearncode;


import com.readlearncode.domain.Book;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonBindingExampleTest extends JsonData {


    @Test
    public void givenJSON_shouldDeserializeBook() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        Book book = jsonBindingExample.deserializeBook();

        assertThat(book).isEqualTo(book1);
    }

    @Test
    public void givenBookObject_shouldSerializeToJSONString() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        String json = jsonBindingExample.serializeBook();

        assertThat(json).isEqualToIgnoringCase(bookJson);
    }

    @Test
    public void givenListOfBooks_shouldSerialiseToJson() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        String json = jsonBindingExample.serializeListOfBooks();

        assertThat(json).isEqualToIgnoringCase(bookListJson);
    }

    @Test
    @Ignore // Does not work as per Docs http://json-b.net/getting-started.html
    public void givenJSON_deserializeToListOfBooks() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        List<Book> actualBooks = jsonBindingExample.deserializeListOfBooks();

        assertThat(actualBooks).isEqualTo(books);
    }

    @Test
    public void givenArrayOfBooks_shouldSerialiseToJson() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        String json = jsonBindingExample.serializeArrayOfBooks();

        assertThat(json).isEqualToIgnoringCase(bookListJson);
    }

    @Test
    public void givenArrayOfStrings_shouldSerialiseToJson() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        String json = jsonBindingExample.serializeArrayOfStrings();

        assertThat(json).isEqualToIgnoringCase("[\"Java EE\",\"Java SE\"]");
    }

    @Test
    public void givenCustomisationOnProperties_shouldProduceJSON() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        String result = jsonBindingExample.customizedMapping();

        assertThat(result).isEqualToIgnoringCase(customisedJson);

        /*
            {
              "author": {
                "first-name": "Alex",
                "last-name": "Theedom"
              },
              "binding": "SOFT_BACK",
              "id": "1234567890",
              "in-print": true,
              "languages": [
                "English",
                "Polish",
                "Russian",
                "Chinese"
              ],
              "pages": 300,
              "price": 25,
              "title": "Professional Java EE Design Patterns"
            }
         */
    }

    @Test
    public void givenCustomisationOnMethods_shouldProduceJSON() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        String result = jsonBindingExample.annotationMethodMapping();

        assertThat(result).isEqualToIgnoringCase(customisedJsonNewspaper);

        /*
            {
              "writer": {
                "firstName": "Alex",
                "lastName": "Theedom"
              },
              "price": "1.00",
              "title": "Java Today"
            }
         */
    }


    @Test
    public void givenCustomisationOnPropertiesAndMethods_shouldProduceJSON() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        String result = jsonBindingExample.annotationPropertyAndMethodMapping();
        assertThat(result).isEqualToIgnoringCase("{\"cost\":\"10.00\",\"author\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"}}");
    }

    @Test
    public void givenAnnotationPojo_shouldProduceJson() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        String result = jsonBindingExample.annotationPropertiesMapping();

        assertThat(result).isEqualToIgnoringCase(expectedMagazine);
    }

    @Test @Ignore("adapter missing")
    public void givenAdapter_shouldSerialiseJSON() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        String result = jsonBindingExample.bookAdapterToJson();
        String json = "{\"isbn\":\"1234567890\",\"bookTitle\":\"Professional Java EE Design Patterns\",\"firstName\":\"Alex\",\"lastName\":\"Theedom\"}";
        assertThat(result).isEqualToIgnoringCase(json);
    }

    @Test @Ignore("Book adapter missing")
    public void givenAdapter_shouldDeserialiseJson() {
        JsonBindingExample jsonBindingExample = new JsonBindingExample();
        Book book = jsonBindingExample.bookAdapterToBook();
        assertThat(book).isEqualTo(bookAdapted);
    }
}