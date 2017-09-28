package com.readlearncode.devWorks.part1.arraysandcollections;

import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ArraysAndCollectionsTest {

    private Jsonb jsonb = JsonbBuilder.create();

    @Test
    public void givenCollectionsMapsArray_shouldSerialiseToJSON() {

        String expectedJson = "{\"ints\":[1,2,3,4,5],\"ints2d\":[[1,2],[3,4],[5,6],[7,8]],\"list\":[\"Fun with Java\",\"Java EE 8 Deep Dive\"],\"map\":{\"John\":10,\"Jane\":10},\"set\":[\"Red\"]}";

        ArraysAndCollections ac = new ArraysAndCollections();
        ac.setInts(new int[]{1, 2, 3, 4, 5});
        ac.setInts2d(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}});
        ac.setList(new ArrayList<String>() {{
            add("Fun with Java");
            add("Java EE 8 Deep Dive");
        }});
        ac.setMap(new HashMap<String, Integer>() {{
            put("John", 10);
            put("Jane", 10);
        }});
        ac.setSet(new HashSet<String>() {{
            add("Red");
        }});

        String actualJson = jsonb.toJson(ac);

        assertThat(expectedJson).isEqualTo(actualJson);
    }

    @Test
    public void givenMap_shouldPreserveRoundTrip() {

        Map<String, Integer> expectedMap = new HashMap<String, Integer>() {{
            put("John", 10);
            put("Jane", 10);
        }};

        Map<String, Integer> actualMap = jsonb.fromJson(jsonb.toJson(expectedMap), Map.class);

        assertThat(actualMap).containsKeys("John", "Jane");

        /*
            {
              "John": 10,
              "Jane": 10
            }
         */
    }

    @Test
    public void givenObjectWithMapProperty_shouldGenerateJSONWithMapProperty() {

        String expectedJson = "{\"scores\":{\"John\":12,\"Jane\":34}}";

        String actualJson = jsonb.toJson(new ScoreBoard());

        assertThat(expectedJson).isEqualTo(actualJson);

        /*
            {
              "scores": {
                "John": 12,
                "Jane": 34
              }
            }
         */
    }


    @Test
    public void givenMapWithNulls_shouldPreserveRoundTrip() {

        Map<String, Integer> expectedMap = new HashMap<String, Integer>() {{
            put("John", 10);
            put("Jane", null);
        }};

        Map<String, Integer> actualMap = jsonb.fromJson(jsonb.toJson(expectedMap), Map.class);

        assertThat(actualMap).containsKeys("John", "Jane");
        assertThat(actualMap.get("Jane")).isNull();

        /*
            {
              "John": 10,
              "Jane": null
            }
         */
    }


}