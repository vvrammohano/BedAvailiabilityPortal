package com.capgemini.bedavailabilityportal;

import com.capgemini.bedavailabilityportal.model.AddBed;
import com.capgemini.bedavailabilityportal.repository.AddBedRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BedavailabilityportalApplicationTests {

	@Autowired
    AddBedRepository addBedRepository;

	@Test
	public  void saveAddBed(){
		AddBed addBed=AddBed.builder()
				.bedId(2L)
				.bedType("Oxygenated")
				.bedAvailability("yes")
				.bedPrice("2000")
				.build();
		addBedRepository.save(addBed);
		Assertions.assertThat(addBed.getBedId()).isGreaterThan(0);
	}
	@Test
	public  void updateAddBed(){
		AddBed addBed=addBedRepository.findById(2L).get();
		addBed.setBedAvailability("Oxygenated");
		addBed.setBedPrice("2000");
		AddBed addBedUpdated=addBedRepository.save(addBed);
		Assertions.assertThat(addBedUpdated.getBedAvailability()).isEqualTo("Oxygenated");
		Assertions.assertThat(addBedUpdated.getBedPrice()).isEqualTo("2000");
	}

	@Test
	public  void getListAddBeds(){
		List<AddBed> rooms=addBedRepository.findAll();
		Assertions.assertThat(rooms.size()).isGreaterThan(0);
	}
	@Test
	public  void getAddBedById(){
		AddBed addBed=addBedRepository.findById(1L).get();
		Assertions.assertThat(addBed.getBedId()).isEqualTo(1);
	}
	@Test
	public void deleteAddBed(){
		AddBed addBed=addBedRepository.findById(2l).get();
		addBedRepository.delete(addBed);

		AddBed addBed1=null;

		Optional<AddBed> optionalAddBed=addBedRepository.findById(2L);

		if(optionalAddBed.isPresent()){
			addBed1=optionalAddBed.get();
		}
		Assertions.assertThat(addBed1).isNull();

	}
}
