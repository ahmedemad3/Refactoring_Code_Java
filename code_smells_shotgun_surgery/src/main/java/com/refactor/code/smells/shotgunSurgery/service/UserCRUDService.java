package com.refactor.code.smells.shotgunSurgery.service;

import java.util.List;

import com.refactor.code.smells.shotgunSurgery.model.UserDTO;

public interface UserCRUDService {
	
	public UserDTO createUser(UserDTO userDTO);
    public UserDTO updateUser(Long id, UserDTO userDTO);
    public void deleteUser(Long id);
    public UserDTO getUser(Long id);
    public List<UserDTO> getAllUsers();

}
