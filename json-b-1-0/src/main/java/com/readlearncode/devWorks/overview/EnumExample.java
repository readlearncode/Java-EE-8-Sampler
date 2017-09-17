package com.readlearncode.devWorks.overview;

import com.readlearncode.devWorks.overview.domain.Binding;

import javax.json.bind.JsonbBuilder;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class EnumExample {

    public String enumSerialisation() {
        return JsonbBuilder.create().toJson(Binding.HARD_BACK.name());
    }

    public class container {
        public Binding binding = Binding.HARD_BACK;
    }

    public String enumSerialisationInObject() {
        return JsonbBuilder.create().toJson(new container());
    }

}