package com.readlearncode.constraints.optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class OptionalExample {

    private Optional<@NotBlank @Size(min = 4, max = 10) String> text;

    @NotNull
    private Optional<String> name;

    public Optional<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Optional.ofNullable(name);
    }

    public Optional<String> getText() {
        return text;
    }

    public void setText(String text) {
        this.text = Optional.of(text);
    }
}