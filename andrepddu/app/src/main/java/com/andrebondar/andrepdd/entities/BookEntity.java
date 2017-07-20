package com.andrebondar.andrepdd.entities;

/**
 * Created by Andre on 09.03.2017.
 */

public class BookEntity {

    private int id;
    private String paragraph;

    public BookEntity(int id, String paragraph) {
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

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", paragraph='" + paragraph + '\'' +
                '}';
    }
}
