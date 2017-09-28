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
public class OptionalExample {

    public Optional<Integer> value;

    public OptionalExample() {
    }

    public OptionalExample(Integer value) {
        this.value = Optional.ofNullable(value);
    }
}