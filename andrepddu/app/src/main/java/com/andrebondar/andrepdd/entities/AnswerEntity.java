package com.andrebondar.andrepdd.entities;

/**
 * Created by Andre on 18.01.2017.
 */

public class AnswerEntity {

    private int id = -1;
    private String descriptionl;

    public AnswerEntity(int id, String descriptionl) {
        this.id = id;
        this.descriptionl = descriptionl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionl() {
        return descriptionl;
    }

    public void setDescriptionl(String descriptionl) {
        this.descriptionl = descriptionl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerEntity that = (AnswerEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "AnswerEntity{" +
                "id=" + id +
                ", descriptionl='" + descriptionl + '\'' +
                '}';
    }
}
