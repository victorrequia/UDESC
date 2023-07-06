package com.api.techgenius.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.techgenius.Service.UserService;
import com.api.techgenius.dto.UserDTO;
import com.api.techgenius.models.User;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(userService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro!");
        }
    }

    @GetMapping("/ranking")
    public ResponseEntity<Object> getTop10Users() {
        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(userService.getTopRanking());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro!");
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO userDTO) {
        var newUser = new User();
        BeanUtils.copyProperties(userDTO, newUser);
        if (userService.userExists(newUser)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(newUser));

    }
}