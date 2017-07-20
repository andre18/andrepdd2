package com.andrebondar.andrepdd.entities;

import java.util.List;

/**
 * Created by Andre on 18.01.2017.
 */

public class QuestionEntity {

    private int id = -1;
    private String title = null;
    private String description = null;
    private List<AnswerEntity> answers = null;
    private List<AnswerEntity> trueAnswers = null;
    private int summTrueAnswers;

    public QuestionEntity(int id, String title, String description, List<AnswerEntity> answers, List<AnswerEntity> trueAnswers, int summTrueAnswers) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.answers = answers;
        this.trueAnswers = trueAnswers;
        this.summTrueAnswers = summTrueAnswers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerEntity> answers) {
        this.answers = answers;
    }

    public List<AnswerEntity> getTrueAnswers() {
        return trueAnswers;
    }

    public void setTrueAnswers(List<AnswerEntity> trueAnswers) {
        this.trueAnswers = trueAnswers;
    }

    public int getSummTrueAnswers() {
        return summTrueAnswers;
    }

    public void setSummTrueAnswers(int summTrueAnswers) {
        this.summTrueAnswers = summTrueAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity that = (QuestionEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", answers=" + answers +
                ", trueAnswers=" + trueAnswers +
                ", summTrueAnswers=" + summTrueAnswers +
                '}';
    }
}
