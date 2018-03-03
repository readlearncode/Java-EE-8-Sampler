package com.readlearncode.containervalidation;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Book {

    private List<@NotBlank String> chapterTitles = new ArrayList<>();

    private Map<@NotBlank String, @NotBlank String> authorChapter = new HashMap<>();

    public List<String> getChapterTitles() {
        return chapterTitles;
    }

    public void addChapterTitle(String chapterTitle) {
        chapterTitles.add(chapterTitle);
    }

    public Map<String, String> getAuthorChapter() {
        return authorChapter;
    }

    public void addAuthorChapter(String author, String chapter) {
        authorChapter.put(author,chapter);
    }
}