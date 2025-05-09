package com.technical.test.hospital.authentication.application.create;

import java.util.List;

@FunctionalInterface
public interface AuthWithPasswordAndEmail {

	List<String> authentication(final String password, final String email);
}
