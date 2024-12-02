package com.jay.RatingService.Repositary;

import com.jay.RatingService.Entites.Rating;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating,Integer> {

    List<Rating> findByUserId(Integer usedId);
    List<Rating> findByHotelId(Integer hotelId);
}
