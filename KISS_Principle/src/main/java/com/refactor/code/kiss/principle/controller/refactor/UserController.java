package com.refactor.code.kiss.principle.controller.refactor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.kiss.principle.dto.UserDTO;
import com.refactor.code.kiss.principle.dto.UserDTOConverter;
import com.refactor.code.kiss.principle.model.User;
import com.refactor.code.kiss.principle.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private UserDTOConverter userDTOConverter;

    @Autowired
    public UserController(UserService userService, UserDTOConverter userDTOConverter) {
        this.userService = userService;
        this.userDTOConverter = userDTOConverter;
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) throws Exception {
        User user = userService.findUserById(id);
        return userDTOConverter.convertToDTO(user);
    }

    @PostMapping
    public void createUser(@RequestBody UserDTO userDTO) {
        User user = userDTOConverter.convertToEntity(userDTO);
        userService.saveUser(user);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return userDTOConverter.convertToDTOList(users);
    }
}

