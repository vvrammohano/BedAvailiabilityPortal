package com.project.BedBookingService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BookingDetails")
@Builder
public class Booking {
    @Id
    private Long bedId;
    private String userId;


}