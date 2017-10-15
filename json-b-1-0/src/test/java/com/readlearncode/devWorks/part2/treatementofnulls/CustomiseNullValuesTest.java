package com.readlearncode.devWorks.part2.treatementofnulls;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CustomiseNullValuesTest {

    @Test
    public void givenNullValuesCustomisation_shouldPreserverNulls(){
        String expectedJson = "{\"author\":{\"firstName\":null,\"lastName\":null},\"title\":\"Fun with Java EE\"}";
        Booklet booklet = new Booklet("Fun with Java EE", null, null);
        JsonbConfig jsonbConfig = new JsonbConfig().withNullValues(true);
        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(booklet);
        assertThat(actualJson).isEqualTo(expectedJson);
    }

}