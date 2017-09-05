package com.readlearncode;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonPointerSimpleTest {

    @Test
    public void givenPointerToTopic_shouldReturnTopic() {
        JsonPointerSimple jsonPointerSimple = new JsonPointerSimple();
        String topic = jsonPointerSimple.find();
        assertThat(topic).isEqualToIgnoringCase("Cloud");
    }

    @Test
    public void givenPointerToTopic_shouldReplaceTopic() {
        JsonPointerSimple jsonPointerSimple = new JsonPointerSimple();
        String topic = jsonPointerSimple.replace();
        assertThat(topic).isEqualToIgnoringCase("Big Data");
    }

    @Test
    public void givenPointerToArrayElement_shouldInsertTopicInToList() {
        JsonPointerSimple jsonPointerSimple = new JsonPointerSimple();
        String topic = jsonPointerSimple.add();
        assertThat(topic).isEqualToIgnoringCase("Java EE");
    }
}