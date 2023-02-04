package com.facility.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facility.entity.Booking;
import com.facility.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getBookings() {
		return bookingRepository.findAll();
	}

	@Override
	public List<Booking> getBookingByPlayerId(Integer playerId) {
		return bookingRepository.findByPlayerId(playerId);
	}

}