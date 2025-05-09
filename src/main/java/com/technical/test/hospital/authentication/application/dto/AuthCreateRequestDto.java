package com.technical.test.hospital.authentication.application.dto;


import com.technical.test.hospital.users.api.validators.ValidEmail;
import com.technical.test.hospital.users.api.validators.ValidPassword;

public record AuthCreateRequestDto(@ValidEmail String email, @ValidPassword String password) {
}
