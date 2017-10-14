package com.readlearncode.devWorks.part2.propertyorder.domain;

import com.readlearncode.devWorks.overview.BookletAdapter;

import javax.json.bind.annotation.JsonbTypeAdapter;
import java.util.Objects;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@JsonbTypeAdapter(BookletAdapter.class)
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