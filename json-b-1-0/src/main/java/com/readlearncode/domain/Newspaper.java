package com.readlearncode.domain;

import javax.json.bind.annotation.*;
import javax.json.bind.config.PropertyOrderStrategy;
import java.util.Objects;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@JsonbNillable
@JsonbPropertyOrder(PropertyOrderStrategy.LEXICOGRAPHICAL)
public class Newspaper {

    private String title;
    private Author author;
    private Float price;
    private boolean inPrint;

    public Newspaper() {
    }

    public Newspaper(String title, Author author, Float price, boolean inPrint) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.inPrint = inPrint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonbProperty("writer")
    public Author getAuthor() {
        return author;
    }

    @JsonbProperty("writer")
    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonbNumberFormat("#0.00")
    public Float getPrice() {
        return price;
    }

    @JsonbNumberFormat("#0.00")
    public void setPrice(Float price) {
        this.price = price;
    }

    @JsonbTransient
    public boolean isInPrint() {
        return inPrint;
    }

    @JsonbTransient
    public void setInPrint(boolean inPrint) {
        this.inPrint = inPrint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Newspaper newspaper = (Newspaper) o;
        return inPrint == newspaper.inPrint &&
                Objects.equals(title, newspaper.title) &&
                Objects.equals(author, newspaper.author) &&
                Objects.equals(price, newspaper.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, inPrint);
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", inPrint=" + inPrint +
                '}';
    }
}