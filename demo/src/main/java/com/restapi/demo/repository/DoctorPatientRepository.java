package com.restapi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.demo.model.DoctorPatient;

public interface DoctorPatientRepository extends JpaRepository<DoctorPatient, Integer> {

	List<DoctorPatient> findByDoctorId(int dId);

}
