package com.cafe.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.constants.CafeConstants;
import com.cafe.services.UserService;
import com.cafe.utils.CafeUtility;

@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		try {
			return userService.signUp(requestMap);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return CafeUtility.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
