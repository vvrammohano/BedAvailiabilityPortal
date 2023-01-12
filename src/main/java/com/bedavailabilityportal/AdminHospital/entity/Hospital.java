package com.bedavailabilityportal.AdminHospital.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "adminPortal")
@Builder
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

	public Hospital() {
	}

	public Hospital(Long hId, String hName, String hNumber, String hAddress, String hState, String hCity, String hType) {
		this.hId = hId;
		this.hName = hName;
		this.hNumber = hNumber;
		this.hAddress = hAddress;
		this.hState = hState;
		this.hCity = hCity;
		this.hType = hType;
//		Beds = beds;
	}

	public Long gethId() {
		return hId;
	}

	public void sethId(Long hId) {
		this.hId = hId;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public String gethNumber() {
		return hNumber;
	}

	public void sethNumber(String hNumber) {
		this.hNumber = hNumber;
	}

	public String gethAddress() {
		return hAddress;
	}

	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}

	public String gethState() {
		return hState;
	}

	public void sethState(String hState) {
		this.hState = hState;
	}

	public String gethCity() {
		return hCity;
	}

	public void sethCity(String hCity) {
		this.hCity = hCity;
	}

	public String gethType() {
		return hType;
	}

	public void sethType(String hType) {
		this.hType = hType;
	}

//	public List<AddBed> getBeds() {
//		return Beds;
//	}
//
//	public void setBeds(List<AddBed> beds) {
//		Beds = beds;
//	}

	@Override
	public String toString() {
		return "Hospital{" +
				"hId=" + hId +
				", hName='" + hName + '\'' +
				", hNumber='" + hNumber + '\'' +
				", hAddress='" + hAddress + '\'' +
				", hState='" + hState + '\'' +
				", hCity='" + hCity + '\'' +
				", hType='" + hType + '\'' +
				'}';
	}
}
