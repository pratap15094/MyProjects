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
public class Facility {
	
	private Integer facilityId;
	private String name;
	private String openingtime;
	private String closingtime;
}
