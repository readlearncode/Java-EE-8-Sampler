package com.readlearncode;

import org.junit.Test;

import javax.json.Json;
import javax.json.JsonArray;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Java8IntegrationTest {

    @Test
    public void givenJsonArray_shouldFilterAllTopicsStartingCToList() throws Exception {
        Java8Integration java8Integration = new Java8Integration();
        List<String> topics = java8Integration.filterJsonArrayToList();

        assertThat(topics).contains("Cloud");
        assertThat(topics).contains("Cognitive");
    }

    @Test
    public void givenJsonArray_shouldFilterAllTopicsStartingCToJsonArray() throws Exception {
        Java8Integration java8Integration = new Java8Integration();
        JsonArray topics = java8Integration.filterJsonArrayToJsonArray();

        assertThat(topics.contains(Json.createValue("Cloud"))).isTrue();
        assertThat(topics.contains(Json.createValue("Cognitive"))).isTrue();
    }

}