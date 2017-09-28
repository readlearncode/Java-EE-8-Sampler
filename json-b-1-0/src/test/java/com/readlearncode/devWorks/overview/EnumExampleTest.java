package com.readlearncode.devWorks.overview;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class EnumExampleTest {

    @Test
    public void enumSerialisationInObject() {
        String expectedJson = "{\"binding\":\"Hard Back\"}";
        EnumExample enumExample = new EnumExample();
        String actualJson = enumExample.enumSerialisationInObject();
        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test @Ignore
    public void givenEnum_shouldThrownExceptionWhenSerialised() {
//        assertThatThrownBy(() ->
                new EnumExample().enumSerialisation();
//        ).isInstanceOf(javax.json.bind.JsonbException.class);
    }

}