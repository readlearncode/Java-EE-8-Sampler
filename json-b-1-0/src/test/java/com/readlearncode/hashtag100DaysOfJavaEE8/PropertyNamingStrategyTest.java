package com.readlearncode.hashtag100DaysOfJavaEE8;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class PropertyNamingStrategyTest {

    public class Book {
        public String bookTitle = "Fun with JSON Binding";
        public String authorName = "Alex Theedom";
        public Float bookPrice = 19.99f;
    }

    @Test
    public void givenPropertyNamingStrategy_shouldSerialise() {

        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);

        String json = JsonbBuilder.create(jsonbConfig).toJson(new Book());

        assertThat(json).isEqualTo("{\"author-name\":\"Alex Theedom\",\"book-price\":19.99,\"book-title\":\"Fun with JSON Binding\"}");

    }

    /*






		JSON Binding allows fine grain control over the format of the
		JSON document. Given an instance of the Book class and the JSON
		Binding code, which JSON document is produced?

		// Book class
		public class Book {
			public String bookTitle = "Fun with JSON Binding";
			public String authorName = "Alex Theedom";
		}

		// JSON binding code
		JsonbConfig jsonbConfig = new JsonbConfig()
				.withPropertyNamingStrategy(
						PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);

		String json = JsonbBuilder.create(jsonbConfig).toJson(new Book());

		// Which JSON document is produced by this code?
	 1. {
		  "author-name": "Alex Theedom",
		  "book-title": "Fun with JSON Binding"
		}

	 2. {
		  "book-title": "Fun with JSON Binding",
		  "author-name": "Alex Theedom"
		}

	 3. {
		  "author-Name": "Alex Theedom",
		  "book-Title": "Fun with JSON Binding"
		}

	 4. {
		  "authorName": "Alex Theedom",
		  "bookTitle": "Fun with JSON Binding"
		}
     */

}