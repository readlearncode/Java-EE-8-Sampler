package com.readlearncode.devWorks.part2.dateandnumberformat;


import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDate;
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

    private LocalDate published;

    public Magazine() {
    }

    public Magazine(String title, String firstName, String lastName, LocalDate published) {
        this.title = title;
        this.authorName = new Author(firstName, lastName);
        this.published = published;
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

    public LocalDate getPublished() {
        return published;
    }
    @JsonbDateFormat(value = "MM/dd/yyyy", locale = "Locale.ENGLISH")
    public void setPublished(LocalDate published) {
        this.published = published;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(title, magazine.title) &&
                Objects.equals(authorName, magazine.authorName) &&
                Objects.equals(published, magazine.published);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorName, published);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + title + '\'' +
                ", authorName=" + authorName +
                ", published=" + published +
                '}';
    }
}