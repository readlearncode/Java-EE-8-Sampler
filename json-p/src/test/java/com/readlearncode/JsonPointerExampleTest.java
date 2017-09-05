package com.readlearncode;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonPointerExampleTest {

    @Test
    public void givenPointerToTopic_shouldReturnTopic() {
        JsonPointerExample jsonPointerExample = new JsonPointerExample();
        String topic = jsonPointerExample.find();
        assertThat(topic).isEqualToIgnoringCase("Cloud");
    }

    @Test
    public void givenPointerToTopic_shouldReplaceTopic() {
        JsonPointerExample jsonPointerExample = new JsonPointerExample();
        String topic = jsonPointerExample.replace();
        assertThat(topic).isEqualToIgnoringCase("Big Data");
    }

    @Test
    public void givenPointerToArrayElement_shouldInsertTopicInToList() {
        JsonPointerExample jsonPointerExample = new JsonPointerExample();
        String topic = jsonPointerExample.add();
        assertThat(topic).isEqualToIgnoringCase("Java EE");
    }
}