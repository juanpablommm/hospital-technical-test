package com.technical.test.hospital.authentication.api;


import com.technical.test.hospital.authentication.application.dto.AuthResponseDto;
import com.technical.test.hospital.authentication.domain.RefreshToken;

public interface RefreshTokenApiMapper {

	AuthResponseDto toAuthResponseDto(final RefreshToken refreshToken);
}
