package com.sport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {
	
	private Integer bookingId;
	private String name;
	private String DOB;
	private String date_of_game;
	private String time_of_game;

	private Booking booking;
	private Facility facility;

}
