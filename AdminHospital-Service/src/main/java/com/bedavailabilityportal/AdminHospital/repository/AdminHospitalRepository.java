package com.bedavailabilityportal.AdminHospital.repository;

import com.bedavailabilityportal.AdminHospital.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminHospitalRepository extends JpaRepository<Hospital, Long>{

}
