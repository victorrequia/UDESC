package com.example.otes06.models;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int score;

    public User() {
    }

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
