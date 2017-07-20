package com.andrebondar.andrepdd.entities;

/**
 * Created by Andre on 10.01.2017.
 */

public class BookRulsEntity {

    private int id;
    private String paragraph;

    public BookRulsEntity(int id, String paragraph) {
        this.id = id;
        this.paragraph = paragraph;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }
}
