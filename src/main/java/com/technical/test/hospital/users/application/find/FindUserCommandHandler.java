package com.technical.test.hospital.users.application.find;


import com.technical.test.hospital.shared.infrastructure.HospitalApplicationException;
import com.technical.test.hospital.users.domain.UserDomain;
import com.technical.test.hospital.users.domain.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FindUserCommandHandler {

	private final UserRepository userRepository;

	public FindUserCommandHandler(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDomain handler(final String username) {
		return this.userRepository.findByEmail(username)
				.orElseThrow(() -> new HospitalApplicationException("User not found", HttpStatus.NOT_FOUND));
	}
}
