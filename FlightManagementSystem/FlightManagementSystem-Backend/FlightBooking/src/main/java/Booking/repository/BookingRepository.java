package Booking.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Booking.pojo.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
	
	  @Query("{'departue_date' : :#{#departure_date}}") 
	  
	  List<Booking> findByDate(@Param("departure_date") Date departure_date); 
}
