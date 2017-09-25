package com.readlearncode.devWorks.part1.basictypes;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Book {

    private String title;

    private String firstname;

    private char middleInitial;
    
    private String lastname;
    
    private Float price;

    private int pages;

    private boolean inPrint;
    
    private AtomicInteger count = new AtomicInteger(0);

    private Byte version;

    public Book() {
    }

    public Book(String title, String firstname, char middleInitial, String lastname, Float price, int pages, boolean inPrint, AtomicInteger count, Byte version) {
        this.title = title;
        this.firstname = firstname;
        this.middleInitial = middleInitial;
        this.lastname = lastname;
        this.price = price;
        this.pages = pages;
        this.inPrint = inPrint;
        this.count = count;
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isInPrint() {
        return inPrint;
    }

    public void setInPrint(boolean inPrint) {
        this.inPrint = inPrint;
    }

    public AtomicInteger getCount() {
        return count;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return middleInitial == book.middleInitial &&
                pages == book.pages &&
                inPrint == book.inPrint &&
                Objects.equals(title, book.title) &&
                Objects.equals(firstname, book.firstname) &&
                Objects.equals(lastname, book.lastname) &&
                Objects.equals(price, book.price) &&
                Objects.equals(count, book.count) &&
                Objects.equals(version, book.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, firstname, middleInitial, lastname, price, pages, inPrint, count, version);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middleInitial=" + middleInitial +
                ", lastname='" + lastname + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", inPrint=" + inPrint +
                ", count=" + count +
                ", version=" + version +
                '}';
    }
}