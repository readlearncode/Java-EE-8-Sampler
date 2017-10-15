package com.readlearncode.devWorks.part2.customcreator;


import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import java.util.Objects;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Magazine {

    private String title;

    private Author authorName;

    @JsonbCreator
    public Magazine(@JsonbProperty("bookTitle") String title,
                    @JsonbProperty("firstName") String firstName,
                    @JsonbProperty("surname") String lastName) {
        this.title = title;
        this.authorName = new Author(firstName, lastName);
    }

    public Magazine() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthorName() {
        return authorName;
    }

    public void setAuthorName(Author authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return
                Objects.equals(title, magazine.title) &&
                        Objects.equals(authorName, magazine.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorName);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + title + '\'' +
                ", authorName=" + authorName +
                '}';
    }
}