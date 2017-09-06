package com.readlearncode.reactive;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */

public class BookRepository {

    @PostConstruct
    public void initiate(){
        books.add(new Book("Java Fun","Alex Theedom", 10f));
        books.add(new Book("Java 101","Alex Theedom", 10f));
        books.add(new Book("Java Expert","Alex Theedom", 10f));
        books.add(new Book("Java EE 8","Alex Theedom", 10f));
    }

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public Book saveBook(Book book) {
        books.add(book);
        return book;
    }

    public Book updateBook(Book book) {
        // check book contains new data then update otherwise return
        books.add(book);
        return book;
    }

    public Book deleteBookByIsbn(String isbn) {
        int i = books.indexOf(new Book(isbn));
        return books.remove(i);
    }

    public List<Book> searchBook(String keyword, int limit) {
        // Search DB for book title containing 'keyword' and return
        // result page of size 'limit'
        return new ArrayList<>();
    }

    public List<Book> getAllNewBooks() {
        return new ArrayList<>();
    }

    public List<Book> getBookBy(String author, String category, String language) {
        return new ArrayList<>();
    }
}
