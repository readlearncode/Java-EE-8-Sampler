package com.readlearncode.devWorks.overview;

import com.readlearncode.domain.Author;

import java.util.Objects;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Booklet {

    private String title;

    private Author author;

    public Booklet(String title, String firstName, String lastName) {
        this.title = title;
        this.author = new Author(firstName, lastName);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booklet booklet = (Booklet) o;
        return Objects.equals(title, booklet.title) &&
                Objects.equals(author, booklet.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "Booklet{" +
                "title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}