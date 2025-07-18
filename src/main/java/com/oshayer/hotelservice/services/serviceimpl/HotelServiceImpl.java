package com.oshayer.hotelservice.services.serviceimpl;

import com.oshayer.hotelservice.entities.Hotel;
import com.oshayer.hotelservice.repositories.HotelRepository;
import com.oshayer.hotelservice.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Lombok will generate constructor for final fields
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Long id, Hotel hotel) {
        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id " + id));
        existingHotel.setHotelName(hotel.getHotelName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setHotelEmail(hotel.getHotelEmail());
        existingHotel.setAbout(hotel.getAbout());
        return hotelRepository.save(existingHotel);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
