package com.jay.RatingService.ServiceImle;

import com.jay.RatingService.Entites.Rating;
import com.jay.RatingService.Repositary.RatingRepository;
import com.jay.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repository;



    @Override
    public Rating createRating(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public List<Rating> getALllRating() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getByRatingByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getByRatingByHotelId(Integer hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
