package com.userview.userveiwmicroservice.repository;

import com.userview.userveiwmicroservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    Booking findBookingByBedId(long l);
}