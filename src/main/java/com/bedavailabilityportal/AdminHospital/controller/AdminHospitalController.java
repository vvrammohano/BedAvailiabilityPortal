package com.bedavailabilityportal.AdminHospital.controller;


import com.bedavailabilityportal.AdminHospital.entity.Hospital;
import com.bedavailabilityportal.AdminHospital.exception.ResourceNotFoundException;
import com.bedavailabilityportal.AdminHospital.repository.AdminHospitalRepository;
import com.bedavailabilityportal.AdminHospital.service.AdminHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class AdminHospitalController {
	
	@Autowired
	private AdminHospitalService service;

	@Autowired
	AdminHospitalRepository adminHospitalRepository;
	
	@PostMapping("/save")
	public String addHospital(@RequestBody Hospital hospital)
	{
		return service.addHospital(hospital);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteHospital(@PathVariable("id") Long hId) {
		return service.deleteHospital(hId);
	}
	
	@GetMapping("/getAll")
	public List<Hospital> getAll(){
		return service.getAll();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Hospital> getHospitalById(@PathVariable(value="id") Long hId)throws ResourceNotFoundException {
		Hospital hospital = adminHospitalRepository.findById(hId)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital  not found:: " + hId));
		return ResponseEntity.ok().body(hospital);
	}
//	@PutMapping("/update/{id}")
//	public String updateHospital(@PathVariable(value="id") Long hId, @RequestBody Hospital hospital) {
//		 service.updateHospital(hId,hospital);
//		 return "updated sucessfully";
//	}

	@PutMapping("/update/{id}")
    public ResponseEntity<Hospital>updateHospital(@PathVariable(value="id") Long hId ,@RequestBody Hospital hospitaldetails) throws ResourceNotFoundException {
		Hospital updateHospital = adminHospitalRepository.findById(hId)
				.orElseThrow(() -> new ResourceNotFoundException("Hospital not  exist with id :" + hId));
		updateHospital.sethId(hospitaldetails.gethId());
		updateHospital.sethName(hospitaldetails.gethName());
		updateHospital.sethNumber(hospitaldetails.gethNumber());
		updateHospital.sethAddress(hospitaldetails.gethAddress());
		updateHospital.sethCity(hospitaldetails.gethCity());
		updateHospital.sethState(hospitaldetails.gethState());
		updateHospital.sethType(hospitaldetails.gethType());
		adminHospitalRepository.save(updateHospital);
		return ResponseEntity.ok(updateHospital);
	}
	}
