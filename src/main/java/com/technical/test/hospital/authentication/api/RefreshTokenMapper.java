package com.technical.test.hospital.authentication.api;

import com.technical.test.hospital.authentication.application.dto.AuthResponseDto;
import com.technical.test.hospital.authentication.domain.RefreshToken;
import org.springframework.stereotype.Component;

public final class RefreshTokenMapper {

	public static AuthResponseDto toAuthResponseDto(RefreshToken refreshToken) {
		return AuthResponseDto.builder()
				.token(refreshToken.getToken())
				.accessToken(refreshToken.getAccessToken())
				.build();
	}
}
