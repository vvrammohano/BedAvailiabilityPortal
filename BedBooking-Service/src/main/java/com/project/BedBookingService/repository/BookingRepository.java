package com.project.BedBookingService.repository;

import com.project.BedBookingService.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    Booking findBookingByBedId(long l);
}