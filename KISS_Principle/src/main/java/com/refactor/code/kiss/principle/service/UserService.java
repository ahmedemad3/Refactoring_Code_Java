package com.refactor.code.kiss.principle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refactor.code.kiss.principle.model.User;
import com.refactor.code.kiss.principle.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findUserById(Long id) throws Exception {
		return userRepository.findById(id).
				orElseThrow(() -> new Exception("user not found"));
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
