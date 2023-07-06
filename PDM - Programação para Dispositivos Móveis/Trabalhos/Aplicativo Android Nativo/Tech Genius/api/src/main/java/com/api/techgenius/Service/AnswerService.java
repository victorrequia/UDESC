package com.api.techgenius.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.techgenius.models.Answer;
import com.api.techgenius.repository.AnswerRepository;

@Service
public class AnswerService {
    final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }
}
