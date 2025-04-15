package com.restapi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demo.model.Doctor;
import com.restapi.demo.model.DoctorPatient;
import com.restapi.demo.model.Patient;
import com.restapi.demo.service.DoctorPatientService;
import com.restapi.demo.service.DoctorService;
import com.restapi.demo.service.PatientService;

@RestController
@RequestMapping("/api/appointment")
public class DoctorPatientController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DoctorPatientService doctorPatientService;
	
	@PostMapping("/add/{pId}/{dId}")
	public DoctorPatient addAppointment(@PathVariable int pId, @PathVariable int dId, 
										@RequestBody DoctorPatient doctorPatient) {
		Patient patient = patientService.findById(pId);
		Doctor doctor = doctorService.findById(dId);
		
		doctorPatient.setPatient(patient);
		doctorPatient.setDoctor(doctor);
		
		return doctorPatientService.addAppointment(doctorPatient);
		
	}
	
	@GetMapping("/get-patient-by-doctor/{dId}")
	public List<Patient> getPatientByDoctor(@PathVariable int dId) {
		doctorService.findById(dId);
		return doctorPatientService.getPatientByDoctor(dId);
	}

}
