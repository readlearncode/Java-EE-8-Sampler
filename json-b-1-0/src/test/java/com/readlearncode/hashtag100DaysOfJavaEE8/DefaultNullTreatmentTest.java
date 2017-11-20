package com.readlearncode.hashtag100DaysOfJavaEE8;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class DefaultNullTreatmentTest {

    public class Book {
        public String title = null;
        public List<String> authors = new ArrayList<String>() {{
            add("Alex Theedom");
            add(null);
        }};
        public Optional<Float> price = Optional.empty();
    }

    @Test
    public void givenPropertiesAreNull_shouldSerialise() {
        String json = JsonbBuilder.create().toJson(new DefaultNullTreatmentTest.Book());
        assertThat(json).isEqualTo("{\"authors\":[\"Alex Theedom\",null]}");
    }

    /*



		How does JSON Binding treat nulls and empty Optionals?
		Given an instance of the Book class, which JSON document
		is produced?

		// Book class
		public class Book {
			public String title = null;
			public List<String> authors = new ArrayList<String>() {{
				add("Alex Theedom");
				add(null);
			}};
			public Optional<Float> price = Optional.empty();
		}

		// Which JSON document is produced?
	 1. {
		  "authors": [
			"Alex Theedom",
			null
		  ],
		  "title": null
		}

	 2. {
		  "authors": [
			"Alex Theedom",
			null
		  ]
		}

	 3. {
		  "authors": [
			"Alex Theedom",
			null
		  ],
		  "price": null,
		  "title": null
		}

	 4. {
		  "authors": [
			"Alex Theedom"
		  ]
		}

     */

}