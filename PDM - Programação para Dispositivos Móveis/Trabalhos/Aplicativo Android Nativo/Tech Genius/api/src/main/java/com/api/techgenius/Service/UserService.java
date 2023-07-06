package com.api.techgenius.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.techgenius.models.User;
import com.api.techgenius.repository.UserRepository;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(String id) {
        return userRepository.findById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getTopRanking() {
        return userRepository.getTopRanking();
    }

    public boolean userExists(User user) {
        var auxUser = findUser(user.getName());
        return auxUser.isPresent();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
