package com.restapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.demo.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
