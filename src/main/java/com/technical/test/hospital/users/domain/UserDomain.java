package com.technical.test.hospital.users.domain;

import java.util.Objects;
import java.util.Set;

public class User {

	private final Long id;
	private final String fullname;
	private final String password;
	private final String email;
	private final Integer age;


	public User(Long id, String fullname, String password, String email, Integer age) {
		this.id = id;
		this.fullname = fullname;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id) && Objects.equals(fullname, user.fullname) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(age, user.age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fullname, password, email, age);
	}
}
