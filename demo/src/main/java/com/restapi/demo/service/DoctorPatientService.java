package com.restapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.demo.model.DoctorPatient;
import com.restapi.demo.model.Patient;
//import com.restapi.demo.model.Patient;
import com.restapi.demo.repository.DoctorPatientRepository;

@Service
public class DoctorPatientService {

	@Autowired
	private DoctorPatientRepository doctorPatientRepository;
	
	/*@Autowired
	private PatientService patientService;*/

	public DoctorPatient addAppointment(DoctorPatient doctorPatient) {
		return doctorPatientRepository.save(doctorPatient);
	}

	public List<Patient> getPatientByDoctor(int dId) {
		
		//List<DoctorPatient> appointmentList = doctorPatientRepository.findByDoctorId(dId);
		
		/*List<Patient> patients = patientService.getAllPatient().stream()
								.filter(p -> appointmentList.contains(p.getId())).toList();*/
		
		List<DoctorPatient> appointmentList = doctorPatientRepository.findByDoctorId(dId);

		List<Patient> patientList = appointmentList.stream()
									.map(DoctorPatient::getPatient)
									.toList();
				
		return patientList;
	}

}
