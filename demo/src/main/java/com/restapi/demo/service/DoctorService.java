package com.restapi.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.demo.model.Doctor;
import com.restapi.demo.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public Doctor findById(int dId) {
		Optional<Doctor> optional = doctorRepository.findById(dId);
		if(optional.isEmpty())
			throw new RuntimeException("Invalid Doctor Id...");
		return optional.get();	
	}

}
