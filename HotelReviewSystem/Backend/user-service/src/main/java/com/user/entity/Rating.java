package com.user.entity;


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
public class Rating {
    private String userId;
    private String hotelId;
    private String ratingId;
    private String feedback;
    private Integer rating;
    
    private Hotel hotel;
}
