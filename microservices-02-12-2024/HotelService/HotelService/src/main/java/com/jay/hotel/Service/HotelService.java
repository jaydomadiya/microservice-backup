package com.jay.hotel.Service;

import com.jay.hotel.Entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);
    Hotel getHotelById(Integer hotelId);

    List<Hotel> getAllHotels();
}
