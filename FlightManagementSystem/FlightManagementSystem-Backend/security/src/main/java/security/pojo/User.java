package security.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Pattern(regexp = "[a-zA-Z ]+", message = "Name should contain only alphabets and spaces")
	private String username;

	private String address;
	private String state;
	private String country;
	@Email(message = "Invalid email address")
	private String email;

	//@Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "PAN must be 12 characters long and can only contain letters and numbers, no spaces or special characters are allowed")
	private String panNumber;
	@Pattern(regexp = "^\\d{10}$", message = "Contact number must be 10 digits long")
	private String number;
	private String dob;
	private String password;

	@Transient
	private Set<Role> roles = new HashSet<>();

	public User(String username, String address, String state, String country, String email, String panNumber,
			String number, String dob, String password) {
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
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}