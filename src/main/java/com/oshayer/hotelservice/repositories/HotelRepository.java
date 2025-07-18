package com.oshayer.hotelservice.repositories;

import com.oshayer.hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // You can add custom query methods if needed
}
