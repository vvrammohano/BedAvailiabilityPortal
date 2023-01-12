package com.bedavailabilityportal.AdminHospital.controller;


import com.bedavailabilityportal.AdminHospital.entity.Hospital;
import com.bedavailabilityportal.AdminHospital.exception.ResourceNotFoundException;
import com.bedavailabilityportal.AdminHospital.repository.AdminHospitalRepository;
import com.bedavailabilityportal.AdminHospital.service.AdminHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/hospitals")
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

//	@GetMapping("/get/{id}")
//	public ResponseEntity<Hospital> getHospitalById(@PathVariable(value="id") Long hId)throws ResourceNotFoundException {
//		Hospital hospital = adminHospitalRepository.findById(hId)
//				.orElseThrow(() -> new ResourceNotFoundException("Hospital  not found:: " + hId));
//		return ResponseEntity.ok().body(hospital);
//	}
	@PutMapping("/update/{id}")
	public Hospital updateHospital(@PathVariable(value="id") Long hId, @RequestBody Hospital hospital) {
		return service.updateHospital(hId,hospital);

	}
	@GetMapping("get/{id}")
	public Hospital getById(@PathVariable("id")Long hId){
		return service.getById(hId);
	}
	@GetMapping("searchName/{name}")
	public List<Hospital> searchByName(@PathVariable("name")String hName){
		return service.searchByName(hName);
	}
	@GetMapping("searchType/{type}")
	public List<Hospital> searchByType(@PathVariable("type")String hType){
		return service.searchByType(hType);
	}


	}
