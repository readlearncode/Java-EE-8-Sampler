package com.readlearncode.constraints.pastorpresent;

import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Dates {

    @PastOrPresent
    private Date past;

    @PastOrPresent
    private LocalDate now;

    @PastOrPresent
    private Year future;

    public Date getPast() {
        return past;
    }

    public void setPast(Date past) {
        this.past = past;
    }

    public LocalDate getNow() {
        return now;
    }

    public void setNow(LocalDate now) {
        this.now = now;
    }

    public Year getFuture() {
        return future;
    }

    public void setFuture(Year future) {
        this.future = future;
    }
}