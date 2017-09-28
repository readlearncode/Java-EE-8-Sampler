package com.readlearncode.devWorks.part2.treatementofnulls;

import javax.json.bind.annotation.JsonbNillable;
import java.util.Optional;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@JsonbNillable
public class OptionalAndValueExample {

    public String name;

    public Optional<Integer> value;

    public OptionalAndValueExample() {
    }

    public OptionalAndValueExample(Integer value) {
        this.value = Optional.ofNullable(value);
    }

    public OptionalAndValueExample(Integer value, String name) {
        this.value = Optional.ofNullable(value);
        this.name = name;
    }
}