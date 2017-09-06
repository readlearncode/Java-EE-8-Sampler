package com.readlearncode;

import java.util.Objects;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BookAdapted   {

    private String id;

    private String bookTitle;

    private String firstName;

    private String lastName;

    public BookAdapted() {
    }

    public BookAdapted(String id, String bookTitle, String firstName, String lastName) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookAdapted that = (BookAdapted) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bookTitle, that.bookTitle) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookTitle, firstName, lastName);
    }

    @Override
    public String toString() {
        return "BookAdapted{" +
                "id='" + id + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}