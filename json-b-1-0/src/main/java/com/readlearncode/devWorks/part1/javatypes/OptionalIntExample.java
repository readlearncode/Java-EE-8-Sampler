package com.readlearncode.devWorks.part1.javatypes;

import java.util.OptionalInt;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class OptionalIntExample {

    public OptionalInt value;

    public OptionalIntExample() {
    }

    public OptionalIntExample(Integer value) {
        this.value = OptionalInt.of(value);
    }
}