package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.Booking;

public interface IBookingRepository extends JpaRepository<Booking,Integer>{
	List<Booking> findByBookingDateAndStartTimeAndEndTime(String bookingDate, String startTime, String endTime);
	List<Booking> findByPlayerId(int playerId);
}
