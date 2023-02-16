package com.user.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.dto.Bookingdto;
import com.user.dto.FacilityDto;
import com.user.entity.User;
import com.user.repository.UserRepository;




@RestController
@CrossOrigin(origins = "*",allowedHeaders="*")
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/createbooking")
	public ResponseEntity<?> createBooking(@RequestBody Bookingdto bookingDetails){
		String url = "http://localhost:8082/createbooking";
		Optional<User> user =  this.userRepo.findById((long)bookingDetails.getPlayerId());
		//bookingDetails.setPlayerId((int) id);
		bookingDetails.setFullName(user.get().getUsername());
		bookingDetails.setLastName(user.get().getUsername());
		bookingDetails.setPlayerDOB(user.get().getDate_of_birth());
		System.out.println(bookingDetails.toString());
		HttpHeaders header =  new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(bookingDetails,header);
		ResponseEntity<String> status = this.restTemplate.exchange(url,HttpMethod.POST,entity,String.class);
		return ResponseEntity.ok(status);
		
	}
	
	@GetMapping("/allfacilities")
	public List<FacilityDto> getAllfacilities(){
		String url = "http://localhost:8082/allfacilities";
		List fac = this.restTemplate.getForObject(url, List.class);
		return fac;
	}
	@GetMapping("/getbookingsbyid/{id}")
	public List<Bookingdto> getBookingById(@PathVariable int id){
		String url = "http://localhost:8082/getallbokkingsByPlayerId/"+id;
		List bookings = this.restTemplate.getForObject(url, List.class);
		return bookings;
	}
	
	@PatchMapping("/updateuser")
	public String  updatePlayer(@RequestBody User user) {
		String msg = "Upadted User "+user.getUsername();
		Optional<com.user.entity.User> dummyUser =
				userRepo.findByUsername(user.getUsername());
		if(dummyUser.isEmpty()) {
			return"Failed to update";
		}
		else
		{
			User tmpUser = dummyUser.get();
			tmpUser.setId(dummyUser.get().getId());
			tmpUser.setAddress_line_1(user.getAddress_line_1());
			tmpUser.setAddress_line_2(user.getAddress_line_2());
			tmpUser.setCity(user.getCity());
			tmpUser.setCountry(user.getCountry());
			tmpUser.setDate_of_birth(user.getDate_of_birth());
			tmpUser.setMob_number(user.getMob_number());
			tmpUser.setPan_number(user.getPan_number());
			tmpUser.setPincode(user.getPincode());
			tmpUser.setState(user.getState());
			userRepo.save(tmpUser);
		}
	return  "Upadted User "+user.getUsername();
	}
}