package com.oshayer.hotelservice.services;

import com.oshayer.hotelservice.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel updateHotel(Long id, Hotel hotel);
    void deleteHotel(Long id);
    Optional<Hotel> getHotelById(Long id);
    List<Hotel> getAllHotels();
}
