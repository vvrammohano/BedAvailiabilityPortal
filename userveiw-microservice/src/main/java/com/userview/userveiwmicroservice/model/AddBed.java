package com.userview.userveiwmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
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
