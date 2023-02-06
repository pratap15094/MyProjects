package Booking.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import Booking.pojo.Booking;
import Booking.pojo.Facility;
import Booking.pojo.Player;
import Booking.repository.BookingRepository;
import Booking.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Booking")
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class bookingController {

	@Autowired
	public BookingRepository bookRepository;

	@Autowired
	public WebClient.Builder webClientBuilder;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	EmailService emailService;

	@PostMapping("/Booking/{mailId}")
	public String booking(@RequestBody Booking booking, @PathVariable("mailId") String mailId) {
		log.info("Making the booking  with pnr:" + booking.getBookingId());

		boolean present = bookRepository.findById(booking.booking_id).isPresent();
		if (present == false) {
			log.info("Made the booking  with pnr:" + booking.getBookingId());
			book_repo.save(booking);
			/* return "Booking made with PNR:"+booking.getBooking_id(); */
			return emailService.sendEmail(booking, mailId);
		}
		log.error("Booking Already present");
		return "Booking Already Made";
	}

	// For User+Attendee to get Details of booking (booking_id=PNR)
	@GetMapping("/BookedFlight/{booking_id}")
	public Optional<Booking> getBooking(@PathVariable("booking_id") long booking_id) {
		try {
			log.info("getting Ticket: " + booking_id);
			return book_repo.findById(booking_id);
		} catch (Exception e) {
			log.error(e.toString());
			return book_repo.findById(booking_id);
		}

	}

//error:-string to date 
//Admin to get all bookings on the date
	@GetMapping("/Booking/{date}/{flight_id}")
	public List<Booking> getBookingByDate(@PathVariable Date date, @PathVariable int flight_id) {
		log.info("getting Ticket: " + flight_id);
		return book_repo.findByDate(date);
	}

// For user to Cancel Booking OR Self Check-In 
	@PutMapping("/booking/{booking_id}/{mailId}")
	public Booking updateBooking(@RequestBody Booking booking, @PathVariable("booking_id") long pnr,
			@PathVariable("mailId") String mailId) {
		Booking dbResponse = book_repo.findById(pnr).get();
		dbResponse.setBooking_cancelled(booking.isBooking_cancelled());
		dbResponse.setChecked_in(booking.isChecked_in());
		log.info("Saving Changes In Booked Ticket Of Booking Cancelled/ CheckIn: " + pnr);
		book_repo.save(dbResponse);

		if (booking.checked_in == true) {
			System.out.println("checked in");
			log.info("Updated CheckIn Status");
			return emailService.checkIn(dbResponse, mailId);
		}
		if (booking.booking_cancelled == true) {
			booking.setChecked_in(false);
			System.out.println("Booking Cancelled");
			log.info("Updated Booking Cancelled Status");
			return emailService.bookingCancelled(dbResponse, mailId);
		}
		return dbResponse;

	}
//Setting total amount for payment gateway fetched from passenger data 

	public double setTotal_amount(Booking booking) {
		double tot_sum = 0;
		List<Player> list = booking.getPassenger();
		for (Player passenger : list) {
			tot_sum += passenger.getAmount();

		}
		return tot_sum;
	}

}
