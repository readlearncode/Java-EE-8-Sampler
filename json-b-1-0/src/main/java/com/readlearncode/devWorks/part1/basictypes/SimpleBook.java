package com.readlearncode.devWorks.part1.basictypes;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class SimpleBook {

    private AtomicInteger version;

    public SimpleBook() {
    }

    public SimpleBook(AtomicInteger version) {
        this.version = version;
    }

    public AtomicInteger getVersion() {
        return version;
    }

    public void setVersion(AtomicInteger version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleBook that = (SimpleBook) o;
        return
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version);
    }

    @Override
    public String toString() {
        return "OptionalExample{" +
                ", version=" + version +
                '}';
    }
}