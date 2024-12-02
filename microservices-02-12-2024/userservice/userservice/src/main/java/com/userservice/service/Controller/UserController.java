package com.userservice.service.Controller;

import com.userservice.service.Entity.User;
import com.userservice.service.Service.UserMicroService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    private UserMicroService microService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(path = "/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User user1 = microService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    @GetMapping(path = "/getAllUsers")
    public ResponseEntity<List<User>> gelAllUsers(){
        List<User> allUsers = microService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }



    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @GetMapping(path = "/getUserId/{userId}")
    public ResponseEntity<User> getByUserId(@PathVariable Integer userId){
        User userById = microService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }

    // creating fall back method for circuitBreaker
    public ResponseEntity<User> ratingHotelFallback(Integer userId,Exception ex){
        logger.info("Fallback is executed because service is down...",ex.getMessage());
        User user = User.builder()
                .email("service@gmail.com")
                .about("Service down...")
                .username("jignesh")
                .id(53)
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}

