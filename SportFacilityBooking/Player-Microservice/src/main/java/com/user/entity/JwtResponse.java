package com.user.entity;

public class JwtResponse {

	private String JwtToken;

	public JwtResponse(String jwtToken) {
		super();
		JwtToken = jwtToken;
	}

	public JwtResponse() {
		super();
	}

	public String getJwtToken() {
		return JwtToken;
	}

	public void setJwtToken(String jwtToken) {
		JwtToken = jwtToken;
	}

}
