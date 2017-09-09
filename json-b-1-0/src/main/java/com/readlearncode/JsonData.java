package com.readlearncode;

import com.readlearncode.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonData {

    public String bookListJson = "[{\"author\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"binding\":\"SOFT_BACK\",\"id\":\"1234567890\",\"inPrint\":true,\"languages\":[\"English\",\"Polish\",\"Russian\",\"Chinese\"],\"pages\":300,\"price\":25.0,\"title\":\"Professional Java EE Design Patterns\"},{\"author\":{\"firstName\":\"John\",\"lastName\":\"Smith\"},\"binding\":\"HARD_BACK\",\"id\":\"ABCD123456\",\"inPrint\":true,\"languages\":[\"English\",\"French\",\"Spanish\",\"Greek\"],\"pages\":435,\"price\":30.0,\"title\":\"JSON-Binding Advanced\"}]";
    public String bookJson = "{\"author\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"binding\":\"SOFT_BACK\",\"id\":\"1234567890\",\"inPrint\":true,\"languages\":[\"English\",\"Polish\",\"Russian\",\"Chinese\"],\"pages\":300,\"price\":25.0,\"title\":\"Professional Java EE Design Patterns\"}";
    public String customisedJson = "\n" +
            "{\n" +
            "    \"author\": {\n" +
            "        \"first-name\": \"Alex\",\n" +
            "        \"last-name\": \"Theedom\"\n" +
            "    },\n" +
            "    \"binding\": \"SOFT_BACK\",\n" +
            "    \"id\": \"1234567890\",\n" +
            "    \"in-print\": true,\n" +
            "    \"languages\": [\n" +
            "        \"English\",\n" +
            "        \"Polish\",\n" +
            "        \"Russian\",\n" +
            "        \"Chinese\"\n" +
            "    ],\n" +
            "    \"pages\": 300,\n" +
            "    \"price\": 25.0,\n" +
            "    \"title\": \"Professional Java EE Design Patterns\"\n" +
            "}";
    public String expectedMagazine = "{\"pages\":300,\"languages\":[\"English\",\"Polish\",\"Russian\",\"Chinese\"],\"writer\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"price\":\"12.00\",\"binding\":null,\"id\":\"1029384756Y\",\"title\":\"Java Today\"}";
    public String customisedJsonNewspaper = "{\"writer\":{\"firstName\":\"Alex\",\"lastName\":\"Theedom\"},\"price\":\"1.00\",\"title\":\"Java Today\"}";

    public Book book1 = new Book();
    public Book book2 = new Book();
    public Book bookAdapted = new Book();

    public List<Book> books = new ArrayList<>();

    public Book[] arrayBooks = {book1, book2};

    public Magazine magazine = new Magazine();

    public Newspaper newspaper = new Newspaper();

    public Booklet booklet = new Booklet();

    public JsonData() {
        Author alex = new Author("Alex", "Theedom");

        book1.setId("1234567890");
        book1.setAuthor(alex);
        book1.setTitle("Professional Java EE Design Patterns");
        book1.setPrice(25.00F);
        book1.setInPrint(true);
        book1.setPages(300);
        book1.setBinding(Binding.SOFT_BACK);
        book1.setLanguages(new ArrayList<String>() {{
            add("English");
            add("Polish");
            add("Russian");
            add("Chinese");
        }});

        Author John = new Author("John", "Smith");

        book2.setId("ABCD123456");
        book2.setAuthor(John);
        book2.setTitle("JSON-Binding Advanced");
        book2.setPrice(30.00F);
        book2.setInPrint(true);
        book2.setPages(435);
        book2.setBinding(Binding.HARD_BACK);
        book2.setLanguages(new ArrayList<String>() {{
            add("English");
            add("French");
            add("Spanish");
            add("Greek");
        }});

        books.add(book1);
        books.add(book2);


        bookAdapted.setId("1234567890");
        bookAdapted.setTitle("Professional Java EE Design Patterns");
        bookAdapted.setAuthor(alex);


        magazine.setId("1029384756Y");
        magazine.setAuthor(alex);
        magazine.setTitle("Java Today");
        magazine.setPrice(12F);
        magazine.setInPrint(true);
        magazine.setPages(300);
        magazine.setBinding(null);
        magazine.setLanguages(new ArrayList<String>() {{
            add("English");
            add("Polish");
            add("Russian");
            add("Chinese");
        }});

        newspaper.setAuthor(alex);
        newspaper.setTitle("Java Today");
        newspaper.setInPrint(true);
        newspaper.setPrice(1.00F);

        booklet.setTitle("Java 101");
        booklet.setPrice(10.00F);
        booklet.setAuthor(alex);

    }

}