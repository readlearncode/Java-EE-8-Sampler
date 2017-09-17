package com.readlearncode.devWorks.overview;


import com.readlearncode.devWorks.overview.domain.Author;
import com.readlearncode.devWorks.overview.domain.Binding;
import com.readlearncode.devWorks.overview.domain.Magazine;

import javax.json.bind.JsonbBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ComprehensiveExample {

    public String serialiseMagazine() throws MalformedURLException {
        Magazine magazine = new Magazine();
        magazine.setId("ABCD-1234");
        magazine.setTitle("Fun with Java");
        magazine.setAuthor(new Author("Alex", "Theedom"));
        magazine.setPrice(45.00f);
        magazine.setPages(300);
        magazine.setInPrint(true);
        magazine.setBinding(Binding.SOFT_BACK);
        magazine.setLanguages(Arrays.asList("French", "English", "Spanish", null));
        magazine.setWebsite(new URL("https://www.readlearncode.com"));
        magazine.setInternalAuditCode("IN-675X-NF09"); // Only has setter method
        magazine.setPublished(LocalDate.parse("01/01/2018", DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        magazine.setAlternativeTitle(null);
        return JsonbBuilder.create().toJson(magazine);
    }


    public Magazine deserialiseMagazine() {
        String json = "{\"author\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"binding\":\"SOFT_BACK\",\"id\":\"ABCD-1234\",\"inPrint\":true,\"languages\":[\"French\",\"English\",\"Spanish\",null],\"pages\":300,\"price\":45.0,\"published\":\"2018-01-01\",\"title\":\"Fun with Java\",\"website\":\"https://www.readlearncode.com\"}";
        return JsonbBuilder.create().fromJson(json, Magazine.class);
    }

}