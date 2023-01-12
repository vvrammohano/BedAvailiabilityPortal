package com.bedavailabilityportal.AdminHospital.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hospital")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="hospitalId")
	private Long hId;
	@Column(name="hospitalName")
	private String hName;
	@Column(name="hospitalNumber")
	private String hNumber;

	@Column(name="hospitalAddress")
	private String hAddress;
	@Column(name="hospitalState")
	private String hState;
	@Column(name="hospitalCity")
	private String hCity;
	@Column(name="hospitalType")
	private String hType;
//    @OneToMany(targetEntity = AddBed.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="HB_fk",referencedColumnName ="hId" )
//	private List<AddBed> Beds;


}
