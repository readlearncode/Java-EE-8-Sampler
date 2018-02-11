package com.readlearncode.constraints.combined;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Book {

    private @NotBlank String id;

    private Optional<@Size(min = 10) @NotEmpty String> title;

    private Author author;

    private @PositiveOrZero Float price;

    private @Positive int pages;

    private @Negative int daysToPromotionEnd;

    private @NegativeOrZero int daysToRelease;

    private @PastOrPresent Year released;

    private @Past LocalDate publishedDate;

    private @FutureOrPresent LocalDate nextVersionRelease;

    private boolean inPrint;

    private Binding binding;

    Map<@Valid String, @Valid Book> otherBooksByAuthor; // Genre, Book

    private List<@Size(min = 30) String> chapterTitles;

    private @NotEmpty List<@NotEmpty String> languages;

    public Book() {
    }

    public Book(@NotBlank String id, Optional<@Size(min = 10) @NotEmpty String> title, @NotEmpty Author author, @PositiveOrZero Float price, @Positive int pages, @Negative int daysToPromotionEnd, @NegativeOrZero int daysToRelease, @PastOrPresent Year released, @Past LocalDate publishedDate, @FutureOrPresent LocalDate nextVersionRelease, boolean inPrint, Binding binding, Map<@Valid String, @Valid Book> otherBooksByAuthor, List<String> chapterTitles, @NotEmpty List<@NotEmpty String> languages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.daysToPromotionEnd = daysToPromotionEnd;
        this.daysToRelease = daysToRelease;
        this.released = released;
        this.publishedDate = publishedDate;
        this.nextVersionRelease = nextVersionRelease;
        this.inPrint = inPrint;
        this.binding = binding;
        this.otherBooksByAuthor = otherBooksByAuthor;
        this.chapterTitles = chapterTitles;
        this.languages = languages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Optional<String> getTitle() {
        return title;
    }

    public void setTitle(Optional<String> title) {
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

    public int getDaysToPromotionEnd() {
        return daysToPromotionEnd;
    }

    public void setDaysToPromotionEnd(int daysToPromotionEnd) {
        this.daysToPromotionEnd = daysToPromotionEnd;
    }

    public int getDaysToRelease() {
        return daysToRelease;
    }

    public void setDaysToRelease(int daysToRelease) {
        this.daysToRelease = daysToRelease;
    }

    public Year getReleased() {
        return released;
    }

    public void setReleased(Year released) {
        this.released = released;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDate getNextVersionRelease() {
        return nextVersionRelease;
    }

    public void setNextVersionRelease(LocalDate nextVersionRelease) {
        this.nextVersionRelease = nextVersionRelease;
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

    public Map<String, Book> getOtherBooksByAuthor() {
        return otherBooksByAuthor;
    }

    public void setOtherBooksByAuthor(Map<String, Book> otherBooksByAuthor) {
        this.otherBooksByAuthor = otherBooksByAuthor;
    }

    public List<String> getChapterTitles() {
        return chapterTitles;
    }

    public void setChapterTitles(List<String> chapterTitles) {
        this.chapterTitles = chapterTitles;
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
        Book book = (Book) o;
        return pages == book.pages &&
                daysToPromotionEnd == book.daysToPromotionEnd &&
                daysToRelease == book.daysToRelease &&
                inPrint == book.inPrint &&
                Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(price, book.price) &&
                Objects.equals(released, book.released) &&
                Objects.equals(publishedDate, book.publishedDate) &&
                Objects.equals(nextVersionRelease, book.nextVersionRelease) &&
                binding == book.binding &&
                Objects.equals(otherBooksByAuthor, book.otherBooksByAuthor) &&
                Objects.equals(chapterTitles, book.chapterTitles) &&
                Objects.equals(languages, book.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price, pages, daysToPromotionEnd, daysToRelease, released, publishedDate, nextVersionRelease, inPrint, binding, chapterTitles, languages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title=" + title +
                ", author=" + author +
                ", price=" + price +
                ", pages=" + pages +
                ", daysToPromotionEnd=" + daysToPromotionEnd +
                ", daysToRelease=" + daysToRelease +
                ", released=" + released +
                ", publishedDate=" + publishedDate +
                ", nextVersionRelease=" + nextVersionRelease +
                ", inPrint=" + inPrint +
                ", binding=" + binding +
                ", otherBooksByAuthor=" + otherBooksByAuthor +
                ", chapterTitles=" + chapterTitles +
                ", languages=" + languages +
                '}';
    }
}