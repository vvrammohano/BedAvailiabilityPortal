package com.bedavailabilityportal.AdminHospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long bedId;
    private String bedType;
    private Long bedPrice;
    private String bedAvailability;;


}