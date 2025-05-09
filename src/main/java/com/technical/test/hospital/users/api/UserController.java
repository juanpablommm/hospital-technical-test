package com.technical.test.hospital.users.api;


import com.technical.test.hospital.users.application.dto.UserRequestDto;
import com.technical.test.hospital.users.application.create.CreateUserCommandHandler;
import com.technical.test.hospital.users.application.delete.DeleteCommandHandler;
import com.technical.test.hospital.users.application.find.FindUserCommandHandler;
import com.technical.test.hospital.users.application.findAll.FindAllCommandHandler;
import com.technical.test.hospital.users.domain.UserDomain;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {

	private final CreateUserCommandHandler createUserCommandHandler;
	private final FindUserCommandHandler findUserCommandHandler;
	private final FindAllCommandHandler findAllCommandHandler;
	private final DeleteCommandHandler deleteCommandHandler;

	@PostMapping(path = "/create")
	public ResponseEntity<String> create(@RequestBody @Valid UserRequestDto createUserRequestDto) {
		final UserDomain user = UserMapper.toDomain(createUserRequestDto);
		this.createUserCommandHandler.handler(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
	}

	@GetMapping(path = "/find/{fullName}")
	public ResponseEntity<UserResponseDto> getByUsername(@PathVariable String fullName) {
		final UserDomain user = this.findUserCommandHandler.handler(fullName);
		return ResponseEntity.ok(UserMapper.toResponseDTO(user));
	}

	@DeleteMapping(path = "/delete")
	public ResponseEntity<?> deleteByUsername(@RequestParam String username) {
		this.deleteCommandHandler.handler(username);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
