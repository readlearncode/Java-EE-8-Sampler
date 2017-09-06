package com.readlearncode;


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
public class MapJsonToObjectTest extends JsonExample {

    @Test
    public void givenJSON_shouldDeserializeBook() {
        MapJsonToObject mapJsonToObject = new MapJsonToObject();
        Book book = mapJsonToObject.deserializeBook();

        assertThat(book).isEqualTo(book1);
    }

    @Test
    public void givenBookObject_shouldSerializeToJSONString() {
        MapJsonToObject mapJsonToObject = new MapJsonToObject();
        String json = mapJsonToObject.serializeBook();

        assertThat(json).isEqualToIgnoringCase(bookJson);
    }

    @Test
    public void givenListOfBooks_shouldSerialiseToJson() {
        MapJsonToObject mapJsonToObject = new MapJsonToObject();
        String json = mapJsonToObject.serializeListOfBooks();

        assertThat(json).isEqualToIgnoringCase(bookListJson);
    }

    @Test
    @Ignore // Does not work as per Docs http://json-b.net/getting-started.html
    public void givenJSON_deserializeToListOfBooks() {
        MapJsonToObject mapJsonToObject = new MapJsonToObject();
        List<Book> actualBooks = mapJsonToObject.deserializeListOfBooks();

        assertThat(actualBooks).isEqualTo(books);
    }

    @Test
    public void givenCustomisation_shouldProduceJSON() {
        MapJsonToObject mapJsonToObject = new MapJsonToObject();
        String result = mapJsonToObject.customizedMapping();

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
    public void givenAnnotationPojo_shouldProduceJson() {
        MapJsonToObject mapJsonToObject = new MapJsonToObject();
        String result = mapJsonToObject.annotationMapping();

        assertThat(result).isEqualToIgnoringCase(expectedMagazine);
    }
}