package com.capgemini.bedavailabilityportal.repository;

import com.capgemini.bedavailabilityportal.model.AddBed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddBedRepository extends JpaRepository<AddBed, Long> {
}
