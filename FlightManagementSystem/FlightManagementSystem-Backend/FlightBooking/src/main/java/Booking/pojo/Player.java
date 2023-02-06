package Booking.pojo;

public class Player {
	
	private Integer playerId;
	// @Pattern(regexp = "[a-zA-Z ]+", message = "Name should contain only alphabets
	// and spaces")
	private String username;
	private String address;
	private String state;
	private String country;
	// @Email(message = "Invalid email address")
	private String email;

//	 @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "PAN must be 12 characters
//	 long and can only contain letters and numbers, no spaces or special
//	 characters are allowed")
	private String panNumber;
	//@Pattern(regexp = "^\\d{10}$", message = "Contact number must be 10 digits long")
	private String number;
	private String dob;
	private String password;
//	@Transient
//	private Set<Role> roles = new HashSet<>();
}
