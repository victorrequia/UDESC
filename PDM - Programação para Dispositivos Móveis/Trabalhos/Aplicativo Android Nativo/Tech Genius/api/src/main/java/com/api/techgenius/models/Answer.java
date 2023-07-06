package com.api.techgenius.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/*
 * create table answer (
	id serial PRIMARY KEY,
	id_question serial not null,
	is_correct BOOLEAN not null,
    answer_text VARCHAR(255) not null,
	foreign key (id_question) references question(id)
)
 */

@Data
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @Column(nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_question", referencedColumnName = "id")
    private Question question;

    @Column(nullable = false)
    private boolean correct_answer;

    @Column(nullable = false)
    private String answer_text;
}
