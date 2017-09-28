package com.readlearncode.devWorks.part1.javatypes;

import java.util.OptionalDouble;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class OptionalDoubleExample {

    public OptionalDouble value;

    public OptionalDoubleExample() {
    }

    public OptionalDoubleExample(Double value) {
        this.value = OptionalDouble.of(value);
    }
}