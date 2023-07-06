package com.api.techgenius.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*
 * CREATE TABLE question (
    id serial PRIMARY KEY,
    question_text VARCHAR(255) not null,
	difficult int not null
);
 */

@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String question_text;

    @Column(nullable = false)
    private int difficult;
}
