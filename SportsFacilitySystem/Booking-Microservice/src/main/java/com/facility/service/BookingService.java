package com.facility.service;

import java.util.List;

import com.facility.booking.Booking;

public interface BookingService {
	
	Booking createBooking(Booking booking);

	List<Booking> getBookings();

	List<Booking> getBookingByPlayerId(Integer playerId);
}
