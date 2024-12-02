package com.userservice.service.ServiceImple;

import com.userservice.service.Entity.Hotel;
import com.userservice.service.Entity.Rating;
import com.userservice.service.Entity.User;
import com.userservice.service.Exception.ResourceNotFoundException;
import com.userservice.service.ExternalService.Service.HotelService;
import com.userservice.service.Repository.UserRepository;
import com.userservice.service.Service.UserMicroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserMicroServiceImple implements UserMicroService {

    @Autowired
    private UserRepository repository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserMicroServiceImple.class);

    @Override
    public User saveUser(User user) {
        User saveUser = new User();
        saveUser.setId(user.getId());
        saveUser.setUsername(user.getUsername());
        saveUser.setEmail(user.getEmail());
        saveUser.setAbout(user.getAbout());
        User save = repository.save(saveUser);

        return save;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = repository.findAll();
        users.forEach(user -> {
            try {
                String ratingServiceUrl = "http://RATINGSERVICE/ratings/getRatingByUserId/" + user.getId();
                Rating[] ratings = restTemplate.getForObject(ratingServiceUrl, Rating[].class);

                List<Rating> list = Arrays.stream(ratings).toList();
                List<Rating> ratingList = list.stream().map(rating -> {
//                    ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/api/getHotelId/" + rating.getHotelId(), Hotel.class);
//                    Hotel hotel = forEntity.getBody();
                    Hotel hotel = hotelService.getHotel(rating.getHotelId());
                    rating.setHotel(hotel);
                    return rating;
                }).collect(Collectors.toList());


                if (ratings != null || ratingList != null) {
                    user.setRatings(List.of(ratings));
                } else {
                    user.setRatings(List.of());
                }

            } catch (Exception e) {
                logger.error("Error fetching ratings for user {}: {}", user.getId(), e.getMessage());
                user.setRatings(List.of());
            }
        });

        return users;
    }

    @Override
    public User getUserById(Integer userId) {
        User user = repository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found  " + userId));

        //localhost:9865/api/getRatingByUserId/3
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/getRatingByUserId/" + user.getId(), Rating[].class);
        List<Rating> list = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = list.stream().map(rating -> {

//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/getHotelId/" + rating.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();

            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());


        logger.info(" []  " + ratingList);
        user.setRatings(ratingList);
        return user;
    }
}
