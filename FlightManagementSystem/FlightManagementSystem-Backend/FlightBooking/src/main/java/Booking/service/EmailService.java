package Booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import Booking.pojo.Booking;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;

	public String sendEmail(Booking booking,String mailId) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("saurabh151@gmail.com");
		//Taking user mail via Rest Template from user Db/User Microservice
		message.setTo(mailId);
		message.setSubject("Booking Confirmation Mail");
		message.setText("Successfull Booking With BookingID: "+booking.getBookingId() +"Player: "+booking.getPlayerId());
		javaMailSender.send(message);
		return "Booking Mail sent successfully";
	}

	public Booking bookingCancelled(Booking booking,String mailId) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("saurabh151@gmail.com");
		//Taking user mail via Rest Template from user Db/User Microservice
		message.setTo(mailId);
		message.setSubject("Booking Cancelled");
		message.setText("Booking Cancelled With BookingID: "+booking.getBookingId() +"Player: "+booking.getPlayerId());
		javaMailSender.send(message);
		return booking;
	}
}