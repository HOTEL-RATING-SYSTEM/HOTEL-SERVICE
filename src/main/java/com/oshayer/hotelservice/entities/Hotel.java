package com.oshayer.hotelservice.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Hotel")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Hotel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelName;
    private String location;
    private String hotelEmail;
    private String about;


}
