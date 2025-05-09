package com.technical.test.hospital.users.infrastructure;


import com.technical.test.hospital.users.domain.UserDomain;

public interface UserMapper {

	UserEntity toEntity(UserDomain user);

	UserDomain toDomain(UserEntity userEntity);
}
