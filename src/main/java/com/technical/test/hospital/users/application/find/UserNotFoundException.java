package com.technical.test.hospital.users.application.find;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(String.format("Error the user cannot be found: %s", message));
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(String.format("Error the user cannot be found: %s", message));
	}
}
