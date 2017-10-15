package com.readlearncode.devWorks.part2.dateandnumberformat;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CustomiseNumberFormatTest {

    @Test
    public void givenJsonbNumberFormatOnPrice_shouldFormatNumber() {
        String expectedJson = "{\"author\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"price\":\"19.00\",\"title\":\"Fun with JSON-B\"}";
        Booklet booklet = new Booklet("Fun with JSON-B", "Alex", "Theedom", 19);
        String actualJson = JsonbBuilder.create().toJson(booklet);
        assertThat(actualJson).isEqualTo(expectedJson);
    }


}