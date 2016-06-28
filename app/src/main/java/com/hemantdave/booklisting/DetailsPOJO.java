package com.hemantdave.booklisting;

/**
 * Created by INDIA on 6/28/2016.
 */
public class DetailsPOJO {
    String authors;
    String Title;

    public DetailsPOJO(String authors, String title) {
        this.authors = authors;
        Title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
