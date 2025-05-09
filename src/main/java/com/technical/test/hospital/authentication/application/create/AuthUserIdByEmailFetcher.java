package com.technical.test.hospital.authentication.application.create;

import java.util.OptionalLong;

@FunctionalInterface
public interface AuthUserIdByEmailFetcher {

	OptionalLong fetch(final String email);
}
