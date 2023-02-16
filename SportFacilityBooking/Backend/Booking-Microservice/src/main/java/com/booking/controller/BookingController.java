package com.booking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.Booking;
import com.booking.entity.Facility;
import com.booking.repository.IBookingRepository;
import com.booking.repository.IFacilityRepository;
import com.booking.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private IBookingRepository bookingRepository;

	@Autowired
	private IFacilityRepository facilityRepo;

	@PostMapping("/addfacility")
	public ResponseEntity<?> addFacility(@RequestBody Facility facility){
		Facility addFacility = this.bookingService.addFacility(facility);
		return ResponseEntity.ok(addFacility);
	}

	@PostMapping("/createbooking")
	public ResponseEntity<?> createBooking(@RequestBody Booking booking){
		String[] str = booking.getStartTime().split(":");
		int startTime = Integer.valueOf(str[0]);
		String[] str1 = booking.getEndTime().split(":");
		int endTime = Integer.valueOf(str1[0]);
		
		if((endTime-startTime)>1 && endTime>startTime) {
			return ResponseEntity.ok("Only 1 hour time slot is allowed");
		}
		
		if(startTime > endTime) {
			return ResponseEntity.ok("Start time cann't be before Endtime!");
		}
		Optional<Facility> opsFac = facilityRepo.findById(booking.getFacilityId());
		booking.setFacilityName(opsFac.get().getFacilityName());
		booking.setFacilityCategory(opsFac.get().getFacilityCategory());
		String createBooking = this.bookingService.createBooking(booking);
		return ResponseEntity.ok(createBooking);
	}

	@GetMapping("/getallbookings")
	public List<Booking> getAllBookings(){
		List<Booking> booking = this.bookingService.getAllBookings();
		return booking;
	}

	@GetMapping("/allfacilities")
	public List<Facility> getAllfacilities(){
		List<Facility> fac = this.facilityRepo.findAll();
		return fac;
	}

	@GetMapping("/getallbokkingsByPlayerId/{id}")
	public List<Booking> getallbokkingsByPlayerId(@PathVariable int id){
		List<Booking> bookings = bookingRepository.findByPlayerId(id);
		return bookings;

	}
}
