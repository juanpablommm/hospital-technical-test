package com.technical.test.hospital.users.infrastructure;


import java.util.Objects;

import com.technical.test.hospital.users.domain.UserDomain;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserModelMapper implements UserMapper {

	private final PasswordEncoder passwordEncoder;

	@Override
	public UserEntity toEntity(UserDomain user) {
		return UserEntity.builder()
				.email(user.email())
				.fullName(user.fullname())
				.password(this.passwordEncoder(user.password()))
				.age(user.age())
				.build();
	}

	@Override
	public UserDomain toDomain(UserEntity userEntity) {
		return new UserDomain(userEntity.getFullName(),
				userEntity.getPassword(), userEntity.getEmail(), userEntity.getAge());
	}



	private String passwordEncoder(final String password) {
		if (Objects.isNull(password) || password.matches("^\\$2[ayb]\\$\\d{2}\\$[./A-Za-z0-9]{53}$"))
			return password;
		return this.passwordEncoder.encode(password);
	}
}
