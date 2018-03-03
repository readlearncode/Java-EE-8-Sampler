package com.readlearncode.containervalidation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ClientChoice {

    private List<@ValidateChoice Choice> choices = new ArrayList<>();

    private Map<@NotBlank String, @NotEmpty List<@ValidateChoice Choice>> clientChoices = new HashMap<>();


    public void addChoices(Choice choice) {
        choices.add(choice);
    }

    public void addClientChoices(String name, List<Choice> choices) {
        clientChoices.put(name, choices);
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public Map<String, List<Choice>> getClientChoices() {
        return clientChoices;
    }

}