package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entity.Booking;
import com.booking.entity.Facility;
import com.booking.repository.IBookingRepository;
import com.booking.repository.IFacilityRepository;

@Service
public class BookingService {

	@Autowired
	IBookingRepository bookingRepository;

	@Autowired
	IFacilityRepository facilityRepository;

	public Facility addFacility(Facility facility){
		facilityRepository.save(facility);
		return facility;
	}

	public String createBooking(Booking booking) {
		String msg = "booked slot!";
		try {
			List<Booking> bookedAlready =
					bookingRepository.findByBookingDateAndStartTimeAndEndTime
					(booking.getBookingDate(), booking.getStartTime(), booking.getEndTime());
			if(bookedAlready.isEmpty()) {
				bookingRepository.save(booking);
				return "Booked";
			}
		}
		catch(Exception ex) {
			System.out.println("ex");
		}
		return msg;
	}

	public List<Booking> getAllBookings(){
		List<Booking> bookings = bookingRepository.findAll();
		return bookings;
	}
}
