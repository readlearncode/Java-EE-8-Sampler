package com.readlearncode.devWorks.overview;


import com.readlearncode.devWorks.overview.domain.Book;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class MinimalExampleTest {

    @Test
    public void givenBookInstance_shouldSerialiseToJSONString() {
        String expectedJson = "{\"author\":\"Alex Theedom\",\"id\":\"SHDUJ-4532\",\"title\":\"Fun with Java\"}";

        MinimalExample minimalExample = new MinimalExample();
        String actualJson = minimalExample.serializeBook();

        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    public void givenJSONString_shouldDeserializeToBookObject() {
        Book expectedBook = new Book("SHDUJ-4532", "Fun with Java", "Alex Theedom");

        MinimalExample minimalExample = new MinimalExample();
        Book actualBook = minimalExample.deserializeBook();

        assertThat(actualBook).isEqualTo(expectedBook);
    }


}