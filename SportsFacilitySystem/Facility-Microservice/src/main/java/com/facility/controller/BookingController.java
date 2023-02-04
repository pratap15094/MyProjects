package com.facility.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facility.entity.Booking;
import com.facility.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(booking));
	}
	
	@GetMapping
	public ResponseEntity<List<Booking>> getRaings(Booking booking){
		return ResponseEntity.ok(bookingService.getBookings());
	}
	
	@GetMapping("/players/{playerId}")
	public ResponseEntity<List<Booking>> getBookingByPlayerId(@PathVariable Integer playerId){
		return ResponseEntity.ok(bookingService.getBookingByPlayerId(playerId));
	}
	
	

}