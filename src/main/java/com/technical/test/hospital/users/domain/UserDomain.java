package com.technical.test.hospital.users.domain;

import java.util.Objects;

public record UserDomain(String fullname, String password, String email, Integer age) {

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		UserDomain that = (UserDomain) o;
		return Objects.equals(age, that.age) && Objects.equals(email, that.email) && Objects.equals(fullname, that.fullname) && Objects.equals(password, that.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fullname, password, email, age);
	}

	@Override
	public String toString() {
		return "UserDomain{" +
				"fullname='" + fullname + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", age=" + age +
				'}';
	}
}
