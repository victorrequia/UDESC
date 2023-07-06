package com.api.techgenius.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.techgenius.Service.AnswerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/answer")
@RestController
public class AnswerController {
    final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllAnswer() {
        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(answerService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro!");
        }
    }
}
