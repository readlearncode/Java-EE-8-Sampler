package com.readlearncode.devWorks.part2.visibility;

import org.junit.Test;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyVisibilityStrategy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class CustomisePropertyVisibilityStrategyTest {

    PropertyVisibilityStrategy vis = new PropertyVisibilityStrategy() {
        @Override
        public boolean isVisible(Field field) {
            return Modifier.isProtected(field.getModifiers());
        }

        @Override
        public boolean isVisible(Method method) {
            return !method.getName().contains("AlternativeTitle");
        }
    };

    @Test
    public void givenPropertyVisibilityStrategy_shouldChangeVisibility() {

        Magazine magazine =  new Magazine("Fun with JSON binding", new Author("Alex", "Theedom"), "Fun with JSON-B");

        String expectedJson = "{\"authorName\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"title\":\"Fun with JSON binding\"}";
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyVisibilityStrategy(vis);

        String actualJson = JsonbBuilder.create(jsonbConfig).toJson(magazine);

        assertThat(actualJson).isEqualTo(expectedJson);
    }


}