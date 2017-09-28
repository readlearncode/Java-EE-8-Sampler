package com.readlearncode.devWorks.part1.javatypes;

import java.util.OptionalLong;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class OptionalLongExample {

    public OptionalLong value;

    public OptionalLongExample() {
    }

    public OptionalLongExample(Long value) {
        this.value = OptionalLong.of(value);
    }
}