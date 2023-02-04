package com.facility.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.facility.booking.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	List<Booking> findByPlayerId(Integer playerId);
	

}
