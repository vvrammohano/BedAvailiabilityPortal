package com.capgemini.bedavailabilityportal.service;

import com.capgemini.bedavailabilityportal.model.AddBed;

import java.util.List;
import java.util.Optional;

public interface BedAddService {
    public AddBed addAddBed(AddBed addBed);

    public Optional<AddBed> findByAddBed(Long addBedId);

    String updateAddBed(Long addBedId, AddBed addBed);

    public List<AddBed> findAllBeds();

    public String deleteBed(Long id);


}