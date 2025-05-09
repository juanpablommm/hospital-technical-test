package com.technical.test.hospital.users.api;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResponseDto {

	private String fullName;
	private String email;
	private Boolean enabled;
	private Integer age;
}
