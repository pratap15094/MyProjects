package com.sport.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.sport.constants.SportConstants;
import com.sport.entity.Users;
import com.sport.jwt.CustomerUsersDetailsService;
import com.sport.jwt.JwtFilter;
import com.sport.jwt.JwtUtil;
import com.sport.repository.UserRepository;
import com.sport.utils.SportUtils;
import com.sport.wrapper.UserWrapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDao;


//	@Autowired
//	private EmailUtils emailUtils;

	@Autowired
	private AuthenticationManager authanticatinManager;

	@Autowired
	private CustomerUsersDetailsService customerUsersDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private JwtFilter jwtFilter;

	// -----------------------------------------------------------------------
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		try {

			if (validateSignUpMap(requestMap)) {
				Users user = userDao.findByEmailId(requestMap.get("email"));
				if (Objects.isNull(user)) {
					userDao.save(getUserFromMap(requestMap));
					return SportUtils.getResponseEntity("Successfully Registerd", HttpStatus.OK);
				} else {
					return SportUtils.getResponseEntity("Email already exits", HttpStatus.BAD_REQUEST);
				}
			} else {
				return SportUtils.getResponseEntity(SportConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SportUtils.getResponseEntity(SportConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// ---------------------------------------------------------------------------------------------------
	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email")
				&& requestMap.containsKey("password")) {
			return true;
		}
		return false;
	}

	// -----------------------------------------------------------------------------------------------------
	private Users getUserFromMap(Map<String, String> requestMap) {
		Users user = new Users();
		user.setName(requestMap.get("name"));
		user.setAddress(requestMap.get("address"));
		user.setState(requestMap.get("state"));
		user.setCountry(requestMap.get("country"));
		user.setEmail(requestMap.get("email"));
		user.setPan(requestMap.get("pan"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setDob(requestMap.get("dob"));
		user.setPassword(requestMap.get("password"));
		user.setRole("user");
		user.setStatus("false");

		return user;
	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		try {

			Authentication auth = authanticatinManager.authenticate(
					new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password")));

			if (auth.isAuthenticated()) {

				if (customerUsersDetailsService.getUserDetails().getStatus().equalsIgnoreCase("true")) {
					return new ResponseEntity<String>(
							"{\"token\":\""
									+ jwtUtil.generateToken(customerUsersDetailsService.getUserDetails().getEmail(),
											customerUsersDetailsService.getUserDetails().getRole())
									+ "\"}",
							HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("{\"message\":\"" + "Wait for admin approval." + "\"}",
							HttpStatus.BAD_REQUEST);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("{\"message\":\"" + "Bad Credential." + "\"}", HttpStatus.BAD_REQUEST);
	}

}
