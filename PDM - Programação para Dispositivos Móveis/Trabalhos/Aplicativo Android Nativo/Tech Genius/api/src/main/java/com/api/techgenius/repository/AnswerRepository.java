package com.api.techgenius.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.techgenius.models.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
