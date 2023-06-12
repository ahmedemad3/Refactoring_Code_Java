package com.refactor.code.dry.principle.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.refactor.code.dry.principle.model.User;
import com.refactor.code.dry.principle.repository.UserRepository;

@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }
    
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
    
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setAge(user.getAge());
            User updatedUser = userRepository.save(existingUser);
            return updatedUser;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
    
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
