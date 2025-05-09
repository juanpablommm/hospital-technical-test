package com.technical.test.hospital.authentication.infrastructure;

import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;

public interface AuthRefreshTokenJpaMapper {

	RefreshTokenEntity toJpaEntity(final RefreshToken refreshToken);

	RefreshToken toDomain(final RefreshTokenEntity refreshTokenEntity);
}
