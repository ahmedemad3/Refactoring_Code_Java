package com.refactor.code.smells.shotgunSurgery.model.refactor;

import org.springframework.stereotype.Component;

import com.refactor.code.smells.shotgunSurgery.model.User;
import com.refactor.code.smells.shotgunSurgery.model.UserDTO;

@Component
public class UserDTOConverter {

	public UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setEmail(user.getEmail());
		return userDTO;
	}

	public User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        return user;
    }

	

}

