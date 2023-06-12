package com.refactor.code.smells.shotgunSurgery.model;

public class UserDTOConverter {

	public static UserDTO convertUserToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setEmail(user.getEmail());
		return userDTO;
	}

}

