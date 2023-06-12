package com.refactor.code.smells.shotgunSurgery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.shotgunSurgery.model.User;
import com.refactor.code.smells.shotgunSurgery.model.UserDTO;
import com.refactor.code.smells.shotgunSurgery.model.UserDTOConverter;
import com.refactor.code.smells.shotgunSurgery.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);

        return ResponseEntity.ok(UserDTOConverter.convertUserToUserDTO(user));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);

        return ResponseEntity.ok(UserDTOConverter.convertUserToUserDTO(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
    
    /**
     * 	Problem 
     * In this example, the UserController class handles all the CRUD operations 
     * for User entities. However, if we want to add a new operation 
     * or modify an existing one, we need to modify this class, 
     * which can lead to Shotgun Surgery.
     * 
     * Solution
     * To address this smell, we can use the Extract Interface technique. 
     * We can create a new interface that defines the CRUD operations 
     * and have the UserController implement this interface.
     */

}

