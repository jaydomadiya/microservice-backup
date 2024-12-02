package com.userservice.service.ExternalService.Service;

import com.userservice.service.Entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

    @GetMapping(path = "/hotels/getHotelId/{hotelId}")
    Hotel getHotel( @PathVariable("hotelId") Integer hotelId);
}
