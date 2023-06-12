package com.refactor.code.smells.shotgunSurgery.controller.refactor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.shotgunSurgery.model.User;
import com.refactor.code.smells.shotgunSurgery.model.UserDTO;
import com.refactor.code.smells.shotgunSurgery.model.refactor.UserDTOConverter;
import com.refactor.code.smells.shotgunSurgery.service.UserCRUDService;
import com.refactor.code.smells.shotgunSurgery.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController implements UserCRUDService {
	
    private UserService userService;
    private UserDTOConverter userDTOConverter;
    
    @Autowired
    public UserController(UserService userService, UserDTOConverter userDTOConverter) {
        this.userService = userService;
        this.userDTOConverter = userDTOConverter;
    }
    
    @PostMapping
    @Override
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        User user = userDTOConverter.convertToEntity(userDTO);
        User createdUser = userService.createUser(user);
        return userDTOConverter.convertToDTO(createdUser);
    }
    
    @PutMapping("/{id}")
    @Override
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = userDTOConverter.convertToEntity(userDTO);
        User updatedUser = userService.updateUser(id, user);
        return userDTOConverter.convertToDTO(updatedUser);
    }
    
    @DeleteMapping("/{id}")
    @Override
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    @GetMapping("/{id}")
    @Override
    public UserDTO getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return userDTOConverter.convertToDTO(user);
    }
    
    @GetMapping
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream()
                    .map(userDTOConverter::convertToDTO)
                    .collect(Collectors.toList());
    }
}
