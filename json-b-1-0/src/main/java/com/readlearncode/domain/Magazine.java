package com.readlearncode.domain;

import javax.json.bind.annotation.*;
import javax.json.bind.config.PropertyOrderStrategy;
import java.util.List;
import java.util.Objects;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@JsonbNillable
@JsonbPropertyOrder(PropertyOrderStrategy.LEXICOGRAPHICAL)
public class Magazine {

    private String id;

    private String title;

    @JsonbProperty("writer")
    private Author author;

    @JsonbNumberFormat("#0.00")
    private Float price;

    private int pages;

    @JsonbTransient
    private boolean inPrint;

    private Binding binding;

    private List<String> languages;

    public Magazine() {
    }

    public Magazine(String id, String title, Author author, Float price, int pages, boolean inPrint, Binding binding, List<String> languages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.inPrint = inPrint;
        this.binding = binding;
        this.languages = languages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Binding getBinding() {
        return binding;
    }

    public void setBinding(Binding binding) {
        this.binding = binding;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine book = (Magazine) o;
        return pages == book.pages &&
                inPrint == book.inPrint &&
                Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(price, book.price) &&
                binding == book.binding &&
                Objects.equals(languages, book.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price, pages, inPrint, binding, languages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", pages=" + pages +
                ", inPrint=" + inPrint +
                ", binding=" + binding +
                ", languages=" + languages +
                '}';
    }
}