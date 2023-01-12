package com.project.BedBookingService.service;

import com.project.BedBookingService.entity.Booking;

import java.util.List;

public interface BookingService {

    public Booking addBooking(Booking  booking);
    public String deleteBooking(Long bedId);
    public List<Booking> findAllBookings();

    public List<Booking> findByUser(Long userId);

}
