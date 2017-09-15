package com.readlearncode.devWorks.overview;


import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Magazine {

    private String id;

    private String title;

    private Author author;

    private Float price;

    private int pages;

    private boolean inPrint;

    private Binding binding;

    private List<String> languages;

    private URL website;

    private String internalAuditCode; // Only has setter method

    private LocalDate published;

    private String alternativeTitle;

    public Magazine() {
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
    public void setInternalAuditCode(String internalAuditCode) {
        this.internalAuditCode = internalAuditCode;
    }

    public URL getWebsite() {
        return website;
    }

    public void setWebsite(URL website) {
        this.website = website;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
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
        return pages == magazine.pages &&
                inPrint == magazine.inPrint &&
                Objects.equals(id, magazine.id) &&
                Objects.equals(title, magazine.title) &&
                Objects.equals(author, magazine.author) &&
                Objects.equals(price, magazine.price) &&
                binding == magazine.binding &&
                Objects.equals(languages, magazine.languages) &&
                Objects.equals(website, magazine.website) &&
                Objects.equals(internalAuditCode, magazine.internalAuditCode) &&
                Objects.equals(published, magazine.published) &&
                Objects.equals(alternativeTitle, magazine.alternativeTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price, pages, inPrint, binding, languages, website, internalAuditCode, published, alternativeTitle);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", pages=" + pages +
                ", inPrint=" + inPrint +
                ", binding=" + binding +
                ", languages=" + languages +
                ", website=" + website +
                ", internalAuditCode='" + internalAuditCode + '\'' +
                ", published=" + published +
                ", alternativeTitle='" + alternativeTitle + '\'' +
                '}';
    }
}