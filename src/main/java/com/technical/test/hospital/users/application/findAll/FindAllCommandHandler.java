package com.technical.test.hospital.users.application.findAll;


import com.technical.test.hospital.shared.infrastructure.HospitalApplicationException;
import com.technical.test.hospital.users.domain.UserDomain;
import com.technical.test.hospital.users.domain.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllCommandHandler {

	private final UserRepository userRepository;

	public FindAllCommandHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserDomain> handler(final int page, final int limit) {
		final List<UserDomain> users = userRepository.findAll(page, limit);
		if (users.isEmpty()) throw new HospitalApplicationException("The user list is empty, no data was found", HttpStatus.NOT_FOUND);
		return users;
	}
}
