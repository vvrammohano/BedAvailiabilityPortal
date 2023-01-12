package com.project.BedBookingService.control;

import com.project.BedBookingService.entity.Booking;
import com.project.BedBookingService.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingControl {

    @Autowired
    BookingService bookingService;
    @PostMapping("/save")
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBooking(@PathVariable(value = "id") Long bedId) {
        return bookingService.deleteBooking(bedId);
    }

    @GetMapping("/find/{id}")
    public List<Booking> findBooking(@PathVariable(value = "id") Long userId) {
        return bookingService.findByUser(userId);
    }

    @GetMapping("/getAll")
    public List<Booking> findAllBookings() {
        return bookingService.findAllBookings();
    }

}