package com.bedavailabilityportal.AdminHospital.service;


import com.bedavailabilityportal.AdminHospital.entity.Hospital;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminHospitalService {
	
	public String addHospital(Hospital hospital);
	
	public String deleteHospital(Long hId);

	public List<Hospital> getAll();
	
	public Hospital updateHospital(Long hId, Hospital hospital);

	public Hospital getById(Long hId);
	public  List<Hospital> searchByName(String hName);

	public List<Hospital> searchByType(String hType);
	

}
