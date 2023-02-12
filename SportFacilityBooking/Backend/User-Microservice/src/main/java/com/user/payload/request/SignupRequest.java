package com.user.payload.request;

import java.util.Set;

public class SignupRequest {

	private String username;
	private String email;
	private String pan_number;
	private String mob_number;
	private String date_of_birth;
	private String password;
	private String address;
	private String city;
	private String state;
	private String country;
	private String role;

	public SignupRequest(String username, String email, String pan_number, String mob_number, String date_of_birth,
			String password, String address, String city, String state, String country, String role) {
		super();
		this.username = username;
		this.email = email;
		this.pan_number = pan_number;
		this.mob_number = mob_number;
		this.date_of_birth=date_of_birth;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.role = role;
	}

	public SignupRequest() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}