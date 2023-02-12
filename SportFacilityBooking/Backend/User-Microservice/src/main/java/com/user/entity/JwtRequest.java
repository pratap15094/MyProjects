package com.user.entity;

public class JwtRequest {
	private String username;
	private String password;

	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public JwtRequest() {
		super();
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}