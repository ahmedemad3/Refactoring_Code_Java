package com.refactor.code.kiss.principle.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.refactor.code.kiss.principle.model.User;

@Component
public class UserDTOConverter {
	
	
    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public List<UserDTO> convertToDTOList(List<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = convertToDTO(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
