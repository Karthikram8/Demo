package com.restapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.demo.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
