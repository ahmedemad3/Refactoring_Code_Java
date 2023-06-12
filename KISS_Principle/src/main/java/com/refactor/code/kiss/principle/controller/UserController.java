package com.refactor.code.kiss.principle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.kiss.principle.dto.UserDTO;
import com.refactor.code.kiss.principle.model.User;
import com.refactor.code.kiss.principle.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) throws Exception {
        User user = userService.findUserById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setFullName(user.getFirstName() + " " + user.getLastName());
        return userDTO;
    }

    @PostMapping
    public void createUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        String[] name = userDTO.getFullName().split(" ");
        user.setFirstName(name[0]);
        user.setLastName(name[1]);
        userService.saveUser(user);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.findAllUsers();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            userDTO.setFullName(user.getFirstName() + " " + user.getLastName());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }
    
    /**
     * Problem
     * In this example, the UserController class is responsible for handling HTTP requests related to users. However, 
     * it includes business logic related to creating and retrieving UserDTOs, 
     * which should be handled by a separate class. 
     * This violates the Single Responsibility Principle and makes the code more complex and difficult to understand.
     */
    
    /**
     * Solution
     * To apply the KISS principle in this code, 
     * we could extract the creation and mapping of UserDTOs into a separate class, 
     * such as a UserDTOConverter. 
     * This would simplify the UserController and make it easier to maintain and understand.
     */
}

