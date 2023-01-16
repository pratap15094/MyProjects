package com.rating.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

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
@Entity
public class Rating {
	
	@Id
	private String ratingId;
	
    private String userId;
    private String hotelId;
    private String feedback;
    private Integer rating;
}

