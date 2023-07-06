package com.api.techgenius.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.techgenius.Service.QuestionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/question")
@RestController
public class QuestionController {
    final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllQuestion() {
        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(questionService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro!");
        }
    }
}
