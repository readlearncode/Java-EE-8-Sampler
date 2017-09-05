package com.readlearncode;

import org.junit.Test;

import javax.json.JsonString;
import javax.json.JsonValue;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonMergePatchExampleTest {

    @Test
    public void givenPatch_sourceValueChanges() throws Exception {
        JsonMergePatchExample jsonMergePatchExample = new JsonMergePatchExample();
        JsonValue result = jsonMergePatchExample.changeValue();

        assertThat(((JsonString)result).getString()).isEqualToIgnoringCase("{\"colour\":\"red\"}");
    }

    @Test
    public void givenPatch_addNewJsonToSource() throws Exception {
        JsonMergePatchExample jsonMergePatchExample = new JsonMergePatchExample();
        JsonValue result = jsonMergePatchExample.addValue();

        assertThat(((JsonString)result).getString()).isEqualToIgnoringCase("{\"colour\":\"blue\",\"blue\":\"light\"}");
    }

    @Test
    public void givenPatch_deleteValue() throws Exception {
        JsonMergePatchExample jsonMergePatchExample = new JsonMergePatchExample();
        JsonValue result = jsonMergePatchExample.deleteValue();

        assertThat(((JsonString)result).getString()).isEqualToIgnoringCase("{}");
    }

}