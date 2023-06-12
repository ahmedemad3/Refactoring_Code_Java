package com.eg.best.practices.code.comment;

import com.eg.best.practices.code.comment.model.User;

public class Validation_Refactor {

	/**
	 * Validates a user object to ensure that it has a non-empty name, email, and
	 * the age is at least 18.
	 * 
	 * @param user The user object to be validated
	 * @throws IllegalArgumentException If any of the validation rules are not met
	 */
	public void validateUser(User user) {
		if (user.getName() == null || user.getName().isEmpty()) { // Check for empty user name
			throw new IllegalArgumentException("User name cannot be empty");
		}
		if (user.getEmail() == null || user.getEmail().isEmpty()) { // Check for empty user email
			throw new IllegalArgumentException("User email cannot be empty");
		}
		if (user.getAge() < 18) { // Check that user is at least 18 years old
			throw new IllegalArgumentException("User must be at least 18 years old");
		}
	}

}
