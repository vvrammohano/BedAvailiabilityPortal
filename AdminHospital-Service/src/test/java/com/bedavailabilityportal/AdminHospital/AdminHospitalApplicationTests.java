package com.bedavailabilityportal.AdminHospital;

import com.bedavailabilityportal.AdminHospital.entity.Hospital;
import com.bedavailabilityportal.AdminHospital.repository.AdminHospitalRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class AdminHospitalApplicationTests {

	@Autowired
	AdminHospitalRepository adminHospitalRepository;

	@Test
	public  void saveAdminHospital(){
		Hospital hospital=Hospital.builder()
				.hId(12L)
				.hAddress("Rajahmundry Main Road 533241")
				.hState("AP")
				.hCity("Rajahmundry")
				.hType("Government")
				.build();
		adminHospitalRepository.save(hospital);
		Assertions.assertThat(hospital.gethId()).isGreaterThan(0);
	}
	@Test
	public  void updateAdminHospital(){
		Hospital hospital=adminHospitalRepository.findById(13L).get();
		hospital.sethType("Private");
		hospital.sethState("AP");
		Hospital hospitalUpdated=adminHospitalRepository.save(hospital);
		Assertions.assertThat(hospitalUpdated.gethType()).isEqualTo("Private");
		Assertions.assertThat(hospitalUpdated.gethState()).isEqualTo("AP");
	}

	@Test
	public  void getListHospitals(){
		List<Hospital> hospitals=adminHospitalRepository.findAll();
		Assertions.assertThat(hospitals.size()).isGreaterThan(0);

	}
	@Test
	public  void getHospitalById(){
		Hospital hospital=adminHospitalRepository.findById(12L).get();
		Assertions.assertThat(hospital.gethId()).isEqualTo(12);
	}

	@Test
	public void deleteHospital(){
		Hospital hospital=adminHospitalRepository.findById(15l).get();
		adminHospitalRepository.delete(hospital);
		Hospital hospital1=null;
		Optional<Hospital> optionalHospital=adminHospitalRepository.findById(15L);
		if(optionalHospital.isPresent()){
			hospital1=optionalHospital.get();
		}
		Assertions.assertThat(hospital1).isNull();

	}

}
