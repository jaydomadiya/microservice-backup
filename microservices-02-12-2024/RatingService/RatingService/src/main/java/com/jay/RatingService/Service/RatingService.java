package com.jay.RatingService.Service;

import com.jay.RatingService.Entites.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    List<Rating> getALllRating();

    List<Rating> getByRatingByUserId(Integer userId);
    List<Rating> getByRatingByHotelId(Integer hotelId);

}
