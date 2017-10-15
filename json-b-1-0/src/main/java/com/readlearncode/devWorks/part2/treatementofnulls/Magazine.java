package com.readlearncode.devWorks.part2.treatementofnulls;


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

    @JsonbProperty(nillable = true)
    private Author authorName;

    private String alternativeTitle;

    public Magazine() {
    }

    public Magazine(String title, Author authorName, String alternativeTitle) {
        this.title = title;
        this.authorName = authorName;
        this.alternativeTitle = alternativeTitle;
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

    public String getAlternativeTitle() {
        return alternativeTitle;
    }

    public void setAlternativeTitle(String alternativeTitle) {
        this.alternativeTitle = alternativeTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return
                Objects.equals(title, magazine.title) &&
                        Objects.equals(authorName, magazine.authorName) &&
                        Objects.equals(alternativeTitle, magazine.alternativeTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorName, alternativeTitle);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + title + '\'' +
                ", authorName=" + authorName +
                ", alternativeTitle='" + alternativeTitle + '\'' +
                '}';
    }
}