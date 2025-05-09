package com.technical.test.hospital.users.application.create;


import com.technical.test.hospital.users.domain.UserDomain;
import com.technical.test.hospital.users.domain.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler {

	private final UserRepository userRepository;

	public CreateUserCommandHandler(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public void handler(UserDomain userDomain) {
		this.userRepository.save(userDomain);
	}
}
