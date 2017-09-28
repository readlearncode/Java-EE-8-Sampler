package com.readlearncode.devWorks.part1.unmappedtypes;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ObjectToMapExampleTest {

    @Test
    public void givenJSONObject_shouldDeserialiseIntoMap() {

        String json = "{\"title\":\"Fun with Java\",\"price\":24.99,\"issue\":null}";

        Object o = JsonbBuilder.create().fromJson(json, Map.class);

        assertThat(o).isInstanceOf(new HashMap<String, Object>().getClass());
    }
}