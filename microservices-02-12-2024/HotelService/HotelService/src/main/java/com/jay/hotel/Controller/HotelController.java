package com.jay.hotel.Controller;

import com.jay.hotel.Entity.Hotel;
import com.jay.hotel.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @PostMapping(path = "/create")
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
        Hotel hotel1 = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping(path = "/getAllHotel")
    public ResponseEntity<List<Hotel>> gelAllUsers(){
        List<Hotel> allHotels = hotelService.getAllHotels();
        return ResponseEntity.ok(allHotels);
    }
    @GetMapping(path = "/getHotelId/{hotelId}")
    public ResponseEntity<Hotel> getByUserId(@PathVariable Integer hotelId){
        Hotel hotelById = hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotelById);
    }

}
