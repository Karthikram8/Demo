package com.restapi.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.demo.model.Patient;
import com.restapi.demo.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public List<Patient> getAllPatient() {
		return patientRepository.findAll();
	}
	
	public Patient findById(int pId) {
		Optional<Patient> optional = patientRepository.findById(pId);
		if(optional.isEmpty())
			throw new RuntimeException("Invalid Patient Id...");
		return optional.get();
	}

	
	
}
