package com.restapi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demo.model.MedicalHistory;
import com.restapi.demo.model.Patient;
import com.restapi.demo.model.User;
import com.restapi.demo.service.AuthService;
import com.restapi.demo.service.MedicalHistoryService;
import com.restapi.demo.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/add/{userId}/{medHisId}")
	public Patient addPatient(@PathVariable int userId, 
								@PathVariable int medHisId, @RequestBody Patient patient) {
		
		User user = authService.findById(userId);
		MedicalHistory medicalHistory = medicalHistoryService.findById(medHisId);
		
		patient.setUser(user);
		patient.setMedicalHistory(medicalHistory);
		
		return patientService.addPatient(patient);
	}
	
}
