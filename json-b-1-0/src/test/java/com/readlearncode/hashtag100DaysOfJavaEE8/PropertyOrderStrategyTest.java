package com.readlearncode.hashtag100DaysOfJavaEE8;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.config.PropertyOrderStrategy;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class PropertyOrderStrategyTest {

    @JsonbPropertyOrder(value = {"authorName", "bookPrice", "bookTitle"})
    public class Book {
        public String bookTitle = "Fun with JSON Binding";
        public String authorName = "Alex Theedom";
        public Float bookPrice = 19.99f;
    }

    @Test
    public void givenPropertyOrderStrategy_shouldSerialise() {

        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyOrderStrategy(PropertyOrderStrategy.REVERSE);

        String json = JsonbBuilder.create(jsonbConfig).toJson(new Book());

        assertThat(json).isEqualTo("{\"authorName\":\"Alex Theedom\",\"bookPrice\":19.99,\"bookTitle\":\"Fun with JSON Binding\"}");

    }

    /*

		JSON Binding allows fine grain control over the order of the
		JSON properties. Given an instance of the Book class and the JSON
		Binding code, which JSON document is produced?

		// Book class
        @JsonbPropertyOrder(value = {"authorName", "bookPrice", "bookTitle"})
        public class Book {
            public String bookTitle = "Fun with JSON Binding";
            public String authorName = "Alex Theedom";
            public Float bookPrice = 19.99f;
        }

		// JSON binding code
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyOrderStrategy(PropertyOrderStrategy.REVERSE);

        String json = JsonbBuilder.create(jsonbConfig).toJson(new Book());

		// Which JSON document is produced by this code?
	 1. {
          "bookTitle": "Fun with JSON Binding",
          "bookPrice": 19.99,
          "authorName": "Alex Theedom"
        }

	 2. {
          "authorName": "Alex Theedom",
          "bookPrice": 19.99,
          "bookTitle": "Fun with JSON Binding"
        }

	 3. {
          "bookTitle": "Fun with JSON Binding",
          "authorName": "Alex Theedom",
          "bookPrice": 19.99
        }

	 4. {
          "bookPrice": 19.99,
          "bookTitle": "Fun with JSON Binding",
          "authorName": "Alex Theedom"
        }



     */

}