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
    public void givenArrayOfBooks_shouldSerialiseToJson() {
        MapJsonToObject mapJsonToObject = new MapJsonToObject();
        String json = mapJsonToObject.serializeArrayOfBooks();

        assertThat(json).isEqualToIgnoringCase(bookListJson);
    }

    @Test
    public void givenArrayOfStrings_shouldSerialiseToJson() {
        MapJsonToObject mapJsonToObject = new MapJsonToObject();
        String json = mapJsonToObject.serializeArrayOfStrings();

        assertThat(json).isEqualToIgnoringCase("[\"Java EE\",\"Java SE\"]");
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

    @Test
    public void givenAdapter_shouldSerialiseJSON() {
        MapJsonToObject mapJsonToObject = new MapJsonToObject();
        String result = mapJsonToObject.bookAdapterToJson();
        String json = "{\"isbn\":\"1234567890\",\"bookTitle\":\"Professional Java EE Design Patterns\",\"firstName\":\"Alex\",\"lastName\":\"Theedom\"}";
        assertThat(result).isEqualToIgnoringCase(json);
    }

    @Test
    public void givenAdapter_shouldDeserialiseJson() {
        MapJsonToObject mapJsonToObject = new MapJsonToObject();
        Book book = mapJsonToObject.bookAdapterToBook();
        assertThat(book).isEqualTo(bookAdapted);
    }
}