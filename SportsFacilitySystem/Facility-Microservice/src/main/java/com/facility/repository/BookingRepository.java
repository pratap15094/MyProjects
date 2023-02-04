package com.facility.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facility.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	List<Booking> findByPlayerId(Integer playerId);
	

}

