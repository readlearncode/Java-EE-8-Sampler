package com.readlearncode;

import org.junit.Test;

import javax.json.JsonMergePatch;
import javax.json.JsonString;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonMergeDiffExampleTest {

    @Test
    public void givenSourceAndTarget_shouldCreateMergePatch(){
        JsonMergeDiffExample jsonMergeDiffExample = new JsonMergeDiffExample();
        JsonMergePatch mergePatch = jsonMergeDiffExample.createMergePatch();
        JsonString jsonString = (JsonString)mergePatch.toJsonValue();

        assertThat(jsonString.getString()).isEqualToIgnoringCase("{\"colour\":\"red\"}");
    }

}