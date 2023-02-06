package security.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


public class SignUpRequest {

	@Pattern(regexp = "[a-zA-Z ]+", message = "Name should contain only alphabets and spaces")
	private String username;

	private String address;
	private String state;
	private String country;
	@Email(message = "Invalid email address")
	private String email;

	@Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "PAN must be 12 characters long and can only contain letters and numbers, no spaces or special characters are allowed")
	private String panNumber;
	
	//@Pattern(regexp = "^\\d{10}$", message = "Contact number must be 10 digits long")
	private String number;
	private String dob;
	private String password;
    
	 private Set<String> roles;
	

	
	public SignUpRequest(
			String username,
			String address, String state, String country,  String email,
			String panNumber,
			 String number, String dob,
			String password, Set<String> roles) {
		super();
		this.username = username;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
		this.panNumber = panNumber;
		this.number = number;
		this.dob = dob;
		this.password = password;
		this.roles = roles;
	}

	public SignUpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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