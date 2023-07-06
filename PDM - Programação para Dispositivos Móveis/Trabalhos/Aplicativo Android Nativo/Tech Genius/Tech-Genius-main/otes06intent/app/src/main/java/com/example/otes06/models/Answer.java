package com.example.otes06.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Answer implements Serializable {
    private int id;

    private int question_id;

    private boolean correct_answer;

    private String answer_text;

    public Answer() {
    }

    public Answer(int id, int question_id, boolean correct_answer, String answer_text) {
        this.id = id;
        this.question_id = question_id;
        this.correct_answer = correct_answer;
        this.answer_text = answer_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean isCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(boolean correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

    public int getQuestionID() {
        return question_id;
    }

    public void setQuestionID(int questionID) {
        this.question_id = questionID;
    }
}
