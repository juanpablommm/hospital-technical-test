package com.technical.test.hospital.authentication.infrastructure;


import com.technical.test.hospital.authentication.domain.AuthRefreshTokenRepository;
import com.technical.test.hospital.authentication.domain.RefreshToken;
import com.technical.test.hospital.users.infrastructure.UserEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Optional;

@Primary
@Component
@AllArgsConstructor
public class AuthRefreshTokenJpaPostgresRepository implements AuthRefreshTokenRepository {

	private final AuthRefreshTokenJpaRepository refreshTokenJpaRepository;

	private final RefreshTokenMapper refreshTokenMapper;

	@Override
	public Optional<RefreshToken> findByToken(final String token) {
		Optional<RefreshTokenEntity> userEntityOptional = this.refreshTokenJpaRepository.findByToken(token);
		return userEntityOptional.map(this.refreshTokenMapper::toDomain);
	}

	@Transactional
	@Override
	public void save(final RefreshToken refreshToken) {
		RefreshTokenEntity refreshTokenEntity = this.refreshTokenMapper.toJpaEntity(refreshToken);
		final UserEntity userEntity = UserEntity.builder().id(refreshToken.getUserId()).build();
		refreshTokenEntity.setUser(userEntity);
		this.refreshTokenJpaRepository.save(refreshTokenEntity);
	}

	@Transactional
	@Override
	public void deleteAllExpiredTokens(OffsetDateTime currentDateTime) {
		this.refreshTokenJpaRepository.deleteAllExpiredTokens(currentDateTime);
	}
}
