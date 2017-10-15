package com.readlearncode.devWorks.part2.dateandnumberformat;

import com.readlearncode.devWorks.overview.domain.Author;

import javax.json.bind.annotation.JsonbNumberFormat;
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

    @JsonbNumberFormat("#.00")
    private double price;

    public Booklet(String title, String firstName, String lastName, double price) {
        this.title = title;
        this.author = new Author(firstName, lastName);
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booklet booklet = (Booklet) o;
        return Double.compare(booklet.price, price) == 0 &&
                Objects.equals(title, booklet.title) &&
                Objects.equals(author, booklet.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price);
    }

    @Override
    public String toString() {
        return "Booklet{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", price=" + price +
                '}';
    }
}