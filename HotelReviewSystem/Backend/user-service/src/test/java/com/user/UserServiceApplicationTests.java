package com.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.user.external.services.RatingService;

@SpringBootTest
@Service
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
 
	@Autowired
	private RatingService ratingService;
	
//	@Test
//	void createRating() {
//		Rating rating = Rating.builder().rating(8).userId("").hotelId("").feedback("Use case for feing clent").build();
//		Rating svaeRating = ratingService.createRating(rating);
//	}
}
