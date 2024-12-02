package com.userservice.service.ExternalService.Service;

import com.userservice.service.Entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "RATINGSERVICE")
@Service
public interface RatingService {

    @PostMapping(path = "/ratings/create")
    Rating createRating(Rating rating);

}
