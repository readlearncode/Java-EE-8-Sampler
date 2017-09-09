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
@JsonbPropertyOrder(PropertyOrderStrategy.REVERSE)
public class Booklet {

    private String title;

    @JsonbProperty("cost")
    @JsonbNumberFormat("#0.00")
    private Float price;

    private Author author;

    @JsonbTransient
    public String getTitle() {
        return title;
    }

    @JsonbTransient
    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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
                Objects.equals(price, booklet.price) &&
                Objects.equals(author, booklet.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, author);
    }

    @Override
    public String toString() {
        return "Booklet{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}