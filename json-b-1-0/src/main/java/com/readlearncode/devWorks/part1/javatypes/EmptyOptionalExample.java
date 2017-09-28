package com.readlearncode.devWorks.part1.javatypes;

import java.util.Optional;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class EmptyOptionalExample {

    public Optional<Integer> value;

    public EmptyOptionalExample() {
    }

    public EmptyOptionalExample(Integer value) {
        if(value == null){
            this.value = Optional.empty();
        } else {
            this.value = Optional.of(value);
        }

    }

}