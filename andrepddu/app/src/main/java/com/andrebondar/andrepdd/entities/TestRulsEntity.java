package com.andrebondar.andrepdd.entities;

/**
 * Created by Andre on 23.01.2017.
 */

public class TestRulsEntity {

    private int id;
    private String bilet;

    public TestRulsEntity(int id, String bilet) {
        this.id = id;
        this.bilet = bilet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBilet() {
        return bilet;
    }

    public void setBilet(String bilet) {
        this.bilet = bilet;
    }
}
