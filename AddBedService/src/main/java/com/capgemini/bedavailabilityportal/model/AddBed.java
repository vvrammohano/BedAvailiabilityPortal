package com.capgemini.bedavailabilityportal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="AddBed")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddBed {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "bedId")
     private Long bedId;
     @Column(name="hospitalName")
     private String hName;
     @Column(name = "bedType")
     private String bedType;
     @Column(name = "bedAvailability")
     private String bedAvailability;
     @Column(name = "bedPrice")
     private String bedPrice;
}
