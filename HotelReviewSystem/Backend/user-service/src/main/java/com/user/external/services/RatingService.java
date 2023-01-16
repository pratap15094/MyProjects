package com.user.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.entity.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	@PostMapping("/ratings")
	Rating createRating(Rating values);
	
	@PutMapping("/ratings/{ratingsId}")
	Rating updateRating(@PathVariable String ratingId, Rating rating);

	@DeleteMapping("/ratings/{ratingsId}")
	public void deleteRating(@PathVariable String ratingId);
}
