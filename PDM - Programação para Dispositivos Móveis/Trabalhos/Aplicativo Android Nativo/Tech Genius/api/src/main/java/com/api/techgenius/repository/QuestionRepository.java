package com.api.techgenius.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.techgenius.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
