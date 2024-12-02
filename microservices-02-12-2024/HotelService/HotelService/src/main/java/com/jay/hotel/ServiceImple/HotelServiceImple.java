package com.jay.hotel.ServiceImple;

import com.jay.hotel.Entity.Hotel;
import com.jay.hotel.Repository.HotelRepository;
import com.jay.hotel.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
@Service
public class HotelServiceImple implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        Hotel save = new Hotel();
        save.setHotelId(hotel.getHotelId());
        save.setHotelName(hotel.getHotelName());
        save.setLocation(hotel.getLocation());
        save.setAbout(hotel.getAbout());

        Hotel save1 = hotelRepository.save(save);

        return save1;
    }

    @Override
    public Hotel getHotelById(Integer hotelId) {
       return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceAccessException("Resource Not Found " + hotelId ));

    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
