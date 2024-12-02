package com.userservice.service.Entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Rating {

    private Integer ratingId;
    private Integer userId;
    private Integer hotelId;
    private Integer rating;
    private String feedback;

    private Hotel hotel;

}
