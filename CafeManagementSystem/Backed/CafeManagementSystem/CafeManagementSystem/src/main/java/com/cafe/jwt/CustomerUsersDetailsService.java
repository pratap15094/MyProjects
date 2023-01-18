package com.cafe.jwt;

import java.util.ArrayList;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cafe.repository.UserRepository;
import org.springframework.security.core.userdetails.User;

@Service
public class CustomerUsersDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private com.cafe.entity.User userDetails;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		userDetails = userRepository.findByEmailId(username);
		if (!Objects.isNull(userDetails)) {
			return new User(userDetails.getEmail(), userDetails.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
	}

	public com.cafe.entity.User getUserDetails() {
		return userDetails;
	}
}
