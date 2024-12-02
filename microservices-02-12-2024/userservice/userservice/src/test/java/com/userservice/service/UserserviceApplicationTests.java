package com.userservice.service;

import com.userservice.service.Entity.Rating;
import com.userservice.service.ExternalService.Service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
class UserserviceApplicationTests {


    @Test
    void contextLoads() {
    }

//    @Autowired
//    private RatingService ratingService;
//
//    @Test
//    void createRating() {
//        Rating build = Rating.builder().rating(8).ratingId(6).userId(2).hotelId(3).feedback("This hotel is awesome").build();
//        Rating rating = ratingService.createRating(build);
//        System.out.println("rating......");
//    }


}
