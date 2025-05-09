package com.technical.test.hospital.users.api;


import com.technical.test.hospital.users.application.dto.UserRequestDto;
import com.technical.test.hospital.users.domain.UserDomain;

public final class UserMapper {


	public static UserDomain toDomain(UserRequestDto userRequestDto) {
		return new UserDomain(userRequestDto.fullName(),
				userRequestDto.password(), userRequestDto.email(), userRequestDto.age());
	}

	public static UserResponseDto toResponseDTO(UserDomain user) {
		return UserResponseDto.builder()
				.fullName(user.fullname())
				.email(user.email())
				.age(user.age())
				.build();
	}
}
