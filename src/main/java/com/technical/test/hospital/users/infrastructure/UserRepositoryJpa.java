package com.technical.test.hospital.users.infrastructure;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByEmailEqualsIgnoreCase(String email);

	@Query(value = "SELECT user.id FROM UserEntity user WHERE user.email = :email")
	Long findUserIdByEmail(String email);


	void deleteByEmailIgnoreCase(String username);
}
