package com.cafe.services;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cafe.constants.CafeConstants;
import com.cafe.entity.User;
import com.cafe.repository.UserRepository;
import com.cafe.utils.CafeUtility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		log.info("inside signup {}", requestMap);
		try {
			if (validateSignUpMap(requestMap)) {
				User user = userRepository.findByEmailId(requestMap.get("email"));
				if (Objects.isNull(user)) {
					userRepository.save(getUserFromMap(requestMap));
					return CafeUtility.getResponseEntity("Successfully Registerd", HttpStatus.OK);
				} else {
					return CafeUtility.getResponseEntity("Email already exits", HttpStatus.BAD_REQUEST);
				}
			} else {
				return CafeUtility.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return CafeUtility.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email")
				&& requestMap.containsKey("password")) {
			return true;
		}
		return false;
	}

	private User getUserFromMap(Map<String, String> requestMap) {
		User user = new User();
		user.setName(requestMap.get("name"));
		user.setContacetNumber(requestMap.get("contactNumber"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setRole("user");
		user.setStatus(false);
		return user;
	}
}
