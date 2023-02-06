package Booking.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private String facility_name;
	private String date_of_game;
	private String time_of_game;

	private Integer playerId;
	private Integer facilityId;

	public Booking() {
		super();
	}

	public Booking(Integer bookingId, String facility_name, String date_of_game, String time_of_game, Integer playerId,
			Integer facilityId) {
		super();
		this.bookingId = bookingId;
		this.facility_name = facility_name;
		this.date_of_game = date_of_game;
		this.time_of_game = time_of_game;
		this.playerId = playerId;
		this.facilityId = facilityId;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}




	public String getFacility_name() {
		return facility_name;
	}

	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}

	public String getDate_of_game() {
		return date_of_game;
	}

	public void setDate_of_game(String date_of_game) {
		this.date_of_game = date_of_game;
	}

	public String getTime_of_game() {
		return time_of_game;
	}

	public void setTime_of_game(String time_of_game) {
		this.time_of_game = time_of_game;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}

}
