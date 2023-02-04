package com.sport.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sport.constants.SportConstants;
import com.sport.service.UserService;
import com.sport.utils.SportUtils;
import com.sport.wrapper.UserWrapper;

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
		return SportUtils.getResponseEntity(SportConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		try {
			return userService.login(requestMap);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SportUtils.getResponseEntity(SportConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
