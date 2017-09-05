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
    public void givenPointerToName_shouldReturnName() throws IOException {


        JsonPointerSimple jsonPointerSimple = new JsonPointerSimple();
        String name = jsonPointerSimple.findName();
        assertThat(name).isEqualToIgnoringCase("duke");


    }

}