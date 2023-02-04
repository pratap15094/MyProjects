package com.sport.wrapper;

public class UserWrapper {
	
	private Integer id;
	private String name;
	private String address;
	private String state;
	private String country;
	private String email;
	private String pan;
	private String contactNumber;
	private String dob;
	public UserWrapper(Integer id, String name, String address, String state, String country, String email, String pan,
			String contactNumber, String dob) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
		this.pan = pan;
		this.contactNumber = contactNumber;
		this.dob = dob;
	}
	public UserWrapper() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
}
