package com.readlearncode;

import org.junit.Test;

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
    public void givenJsonArray_shouldFilterAllTopicsStartingC() throws Exception {
        Java8Integration java8Integration = new Java8Integration();
        List<String> topics = java8Integration.filterJsonArray();

        assertThat(topics).contains("Cloud");
        assertThat(topics).contains("Cognitive");
    }

}