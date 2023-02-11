package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserService userService;


	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public String userAccess() {
		return "User Content.";
		// resttemplate taking to booking
	}

	@GetMapping("/attendee")
	@PreAuthorize("hasRole('ATTENDEE')")
	public String attendeeAccess() {
		return "Attendee Board.";
		// resttemplate taking to check_in
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN') or hasRole('ATTENDEE') or hasRole('USER')")
	public String adminAccess() {
		return "Admin Board.";
		// resttemplate taking to admin
	}
	
}
