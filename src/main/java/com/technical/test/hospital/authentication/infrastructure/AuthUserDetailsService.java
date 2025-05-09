package com.technical.test.hospital.authentication.infrastructure;


import com.technical.test.hospital.shared.infrastructure.HospitalApplicationException;
import com.technical.test.hospital.users.domain.UserDomain;
import com.technical.test.hospital.users.domain.UserRepository;
import com.technical.test.hospital.users.infrastructure.UserModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	private UserModelMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		UserDomain user = userRepository.findByEmail(email)
				.orElseThrow(() -> new HospitalApplicationException("User not fount", HttpStatus.NOT_FOUND));

		return this.userMapper.toEntity(user);
	}
}
