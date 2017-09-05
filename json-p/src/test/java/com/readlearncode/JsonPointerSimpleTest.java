package com.readlearncode;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonPointerSimpleTest {

    @Test
    public void givenPointerToTopic_shouldReturnTopic() throws IOException {
        JsonPointerSimple jsonPointerSimple = new JsonPointerSimple();
        String name = jsonPointerSimple.find();
        assertThat(name).isEqualToIgnoringCase("Cloud");
    }

    @Test
    public void givenPointerToTopic_shouldReplaceTopic() throws IOException {
        JsonPointerSimple jsonPointerSimple = new JsonPointerSimple();
        String name = jsonPointerSimple.replace();
        assertThat(name).isEqualToIgnoringCase("Big Data");
    }
}