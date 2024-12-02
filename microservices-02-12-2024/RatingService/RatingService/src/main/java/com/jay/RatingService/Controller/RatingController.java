package com.jay.RatingService.Controller;

import com.jay.RatingService.Entites.Rating;
import com.jay.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/ratings")
public class RatingController {


    @Autowired
    private RatingService ratingService;

    @PostMapping(path = "/create")
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        Rating rating1 = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping(path = "/getAllRating")
    public ResponseEntity<List<Rating>> getAllRating(){
        List<Rating> aLllRating = ratingService.getALllRating();
        return ResponseEntity.ok(aLllRating);
    }

    @GetMapping(path = "/getRatingByUserId/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Integer userId){
        List<Rating> byRatingByUserId = ratingService.getByRatingByUserId(userId);
        return ResponseEntity.ok(byRatingByUserId);
    }

    @GetMapping(path = "/getRatingByHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable Integer hotelId) {
        List<Rating> byRatingByHotelId = ratingService.getByRatingByHotelId(hotelId);
        return ResponseEntity.ok(byRatingByHotelId);
    }

}
