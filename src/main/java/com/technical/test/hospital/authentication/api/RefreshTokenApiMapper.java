package com.technical.test.hospital.authentication.api;

import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;

public interface RefreshTokenApiMapper {

	AuthResponseDto toAuthResponseDto(final RefreshToken refreshToken);
}
