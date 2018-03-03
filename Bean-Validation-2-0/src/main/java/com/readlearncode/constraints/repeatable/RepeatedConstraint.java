package com.readlearncode.constraints.repeatable;

import javax.validation.constraints.Pattern;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class RepeatedConstraint {

    @Pattern(regexp = ".*com")
    @Pattern(regexp = "^([a-z0-9]+(-[a-z0-9]+)*\\.)+[a-z]{2,}$")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}