package com.api.techgenius.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.techgenius.models.Question;
import com.api.techgenius.repository.QuestionRepository;

@Service
public class QuestionService {

    final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }
}
