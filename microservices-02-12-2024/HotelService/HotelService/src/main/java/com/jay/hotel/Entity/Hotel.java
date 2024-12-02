package com.jay.hotel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer hotelId;

    @Column(name = "name")
    private String hotelName;

    @Column(name = "location")
    private String location;

    @Column(name = "about")
    private String about;
}
