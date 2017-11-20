package com.readlearncode.devWorks.overview;

import com.readlearncode.devWorks.overview.domain.Author;
import com.readlearncode.devWorks.overview.domain.Binding;
import com.readlearncode.devWorks.overview.domain.Magazine;
import org.junit.Ignore;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ComprehensiveExampleTest {

    @Test @Ignore("failing test fix!")
    public void givenMagazine_shouldSerialiseToJson() throws MalformedURLException {
        String expectedJson = "{\"author\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"binding\":\"SOFT_BACK\",\"id\":\"ABCD-1234\",\"inPrint\":true,\"languages\":[\"French\",\"English\",\"Spanish\",null],\"pages\":300,\"price\":45.0,\"published\":\"2018-01-01\",\"title\":\"Fun with Java\",\"website\":\"https://www.readlearncode.com\"}";
        ComprehensiveExample comprehensiveExample = new ComprehensiveExample();
        String actualJson = comprehensiveExample.serialiseMagazine();

        assertThat(actualJson).isEqualTo(expectedJson);

        /*
            {
              "author": {
                "firstName": "Alex",
                "lastName": "Theedom"
              },
              "binding": "SOFT_BACK",
              "id": "ABCD-1234",
              "inPrint": true,
              "languages": [
                "French",
                "English",
                "Spanish",
                null
              ],
              "pages": 300,
              "price": 45.0,
              "published": "2018-01-01",
              "title": "Fun with Java",
              "website": "https://www.readlearncode.com"
            }
         */
    }

    @Test
    public void givenJson_shouldDeserialiseToMagazine() throws MalformedURLException {

        Magazine expectedMagazine = new Magazine();
        expectedMagazine.setId("ABCD-1234");
        expectedMagazine.setTitle("Fun with Java");
        expectedMagazine.setAuthor(new Author("Alex", "Theedom"));
        expectedMagazine.setPrice(45.00f);
        expectedMagazine.setPages(300);
        expectedMagazine.setInPrint(true);
        expectedMagazine.setBinding(Binding.SOFT_BACK);
        expectedMagazine.setLanguages(Arrays.asList("French", "English", "Spanish", null));
        expectedMagazine.setWebsite(new URL("https://www.readlearncode.com"));
        expectedMagazine.setInternalAuditCode(null); // Only has setter method
        expectedMagazine.setPublished(LocalDate.parse("01/01/2018", DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        expectedMagazine.setAlternativeTitle(null);
        ComprehensiveExample comprehensiveExample = new ComprehensiveExample();
        Magazine actualMagazine = comprehensiveExample.deserialiseMagazine();

        assertThat(actualMagazine).isEqualTo(expectedMagazine);
    }

}