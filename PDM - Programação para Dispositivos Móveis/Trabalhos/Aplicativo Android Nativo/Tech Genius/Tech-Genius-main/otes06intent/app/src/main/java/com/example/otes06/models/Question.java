package com.example.otes06.models;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private int id;

    private String question_text;

    private int difficult;
    private List<Answer> answers;

    public Question() {
    }

    public Question(int id, String question_text, int difficult, List<Answer> answers) {
        this.id = id;
        this.question_text = question_text;
        this.difficult = difficult;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
