package com.andrebondar.andrepdd.entities;

/**
 * Created by Andre on 09.03.2017.
 */

public class CardViewEntity {

    private int image;
    private String title;

    public CardViewEntity(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CardViewEntity{" +
                "image=" + image +
                ", title='" + title + '\'' +
                '}';
    }
}
