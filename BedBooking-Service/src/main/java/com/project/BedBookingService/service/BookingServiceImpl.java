package com.project.BedBookingService.service;

import com.project.BedBookingService.entity.Booking;
import com.project.BedBookingService.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public String deleteBooking(Long bedId) {
        java.util.Optional<Booking> Container = bookingRepository.findById(String.valueOf(bedId));
        if (Container.isPresent()) {
            Booking cust =Container.get();
            bookingRepository.delete(cust);
            return " Booking Deleted Successfully"+  bedId;
        } else {
            return "not found";
        }
    }
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> findByUser(Long userId) {
        return bookingRepository.findAll().stream().filter(n->n.getUserId().equals(userId)).collect(Collectors.toList());
    }

}
