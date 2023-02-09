package com.user.payload.request;

import java.util.Set;

public class SignupRequest {

	private String username;
	private String email;
	private String pan_number;
	private String mob_number;
	private String DOB;
	private String address;
	private String city;
	private String state;
	private String country;
	private String password;
	
	private Set<String> roles;
	
	public SignupRequest(String username, String email, String pan_number, String mob_number, String DOB,
			String address, String city, String state, String country, String password) {
		super();
		this.username = username;
		this.email = email;
		this.pan_number = pan_number;
		this.mob_number = mob_number;
		this.DOB = DOB;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPan_number() {
		return pan_number;
	}

	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}

	public String getMob_number() {
		return mob_number;
	}

	public void setMob_number(String mob_number) {
		this.mob_number = mob_number;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	
}
