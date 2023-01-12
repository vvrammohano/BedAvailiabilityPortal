package com.capgemini.bedavailabilityportal.service;

import com.capgemini.bedavailabilityportal.model.AddBed;
import com.capgemini.bedavailabilityportal.repository.AddBedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BedAddServiceImpl   implements BedAddService{
    @Autowired
    private AddBedRepository addBedRepository;

    public AddBed addAddBed (AddBed addBed) {
        AddBed mv = addBedRepository.save(addBed);
        return mv;
    }

    @Override
    public Optional<AddBed> findByAddBed(Long moveId) {
        return addBedRepository.findById(moveId);
    }

    @Override
    public String updateAddBed(Long addBedId, AddBed addBed) {
        Optional<AddBed> Container = addBedRepository.findById(Long.valueOf(addBedId));
        if (Container.isPresent()) {
            AddBed Bed = Container.get();
            Bed.setBedId(addBed.getBedId());
            Bed.setHName(addBed.getHName());
            Bed.setBedType(addBed.getBedType());
            Bed.setBedAvailability(addBed.getBedAvailability());
            Bed.setBedPrice(addBed.getBedPrice());
            addBedRepository.save(Bed);
            return "AddBed Updated Successfully with"+ addBedId ;
        } else {
            return "Id not found";
        }
    }

    @Override
    public List<AddBed> findAllBeds() {
        return addBedRepository.findAll();
    }

    @Override
    public String deleteBed(Long id) {
        addBedRepository.deleteById(id);
        return "Deleted";
    }

}

