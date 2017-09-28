package com.readlearncode.devWorks.part1.datetimetypes;

import org.junit.Test;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class DateTimeExampleTest {

    private Jsonb jsonb = JsonbBuilder.create();

    @Test
    public void givenDate_shouldParseAndSerialise() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse("25/12/2018");
        String json = jsonb.toJson(date);

        assertThat("\"2018-12-25T00:00:00Z[UTC]\"").isEqualTo(json);
    }

    @Test
    public void givenDuration_shouldSerialiseAsDuration() throws ParseException {
        String json = jsonb.toJson(Duration.ofHours(4).plusMinutes(3).plusSeconds(2));

        assertThat("\"PT4H3M2S\"").isEqualTo(json);
    }
}