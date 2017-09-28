package com.readlearncode.devWorks.part1.javatypes;

import java.util.Optional;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class OptionalExample {

    public Optional<Integer> value;

    public OptionalExample() {
    }

    public OptionalExample(Integer value) {
        this.value = Optional.of(value);
    }
}