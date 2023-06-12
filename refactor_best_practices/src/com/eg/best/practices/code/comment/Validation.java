package com.eg.best.practices.code.comment;

import com.eg.best.practices.code.comment.model.User;

public class Validation {

	public void validateUser(User user) {

		if (user.getName() == null || user.getName().isEmpty()) {
			throw new IllegalArgumentException("User name cannot be empty");
		}
		if (user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new IllegalArgumentException("User email cannot be empty");
		}
		if (user.getAge() < 18) {
			throw new IllegalArgumentException("User must be at least 18 years old");
		}
	}

}
