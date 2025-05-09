package com.technical.test.hospital.users.application.dto;


import com.technical.test.hospital.users.api.validators.ValidEmail;
import com.technical.test.hospital.users.api.validators.ValidPassword;


public record UserRequestDto(String fullName, @ValidPassword String password,
		@ValidEmail String email, Integer age) {
}
