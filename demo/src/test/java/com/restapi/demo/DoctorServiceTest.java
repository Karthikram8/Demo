package com.restapi.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.restapi.demo.enums.Speciality;
import com.restapi.demo.model.Doctor;
import com.restapi.demo.model.DoctorPatient;
import com.restapi.demo.model.Patient;
import com.restapi.demo.model.User;
import com.restapi.demo.repository.DoctorRepository;
import com.restapi.demo.service.DoctorService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {
	
	@InjectMocks
	private DoctorService doctorService;
	
	@Mock
	private DoctorRepository doctorRepository; 
	
	
	
	Patient p1;
	Patient p2;
	Patient p3;
	
	Optional<Doctor> d1;
	
	DoctorPatient dp1;
	DoctorPatient dp2;
	
	@BeforeEach
	public void init() {
		/*p1 = new Patient(1, "emma", 20, 
				new User(1, "emma", "emma", "PATIENT"), 
				new MedicalHistory(1, "head ache", 1, "severe pain"));	
		
		p2 = new Patient(2, "tony", 21, 
				new User(1, "tony", "tony", "PATIENT"), 
				new MedicalHistory(2, "head ache", 2, "severe pain"));	
		
	
		/*d1 = new DoctorPatient(1, 
				new Doctor(1, "john", "ORTHO", new User(1, "john", "john123", "DOCTOR")), 
				new Patient(1, "emma", 20, new User(2, "emma", "emma", "PATIENT"), new MedicalHistory(1, "head ache", 1, "severe pain"),
				LocalDateTime.parse("2024-07-15T14:30:00")), null;
		
		d1;*/	
		
		d1 = Optional.ofNullable(new Doctor(1, "john", Speciality.ORTHO, new User(1, "john", "john", "DOCTOR")));
		
	}
	
	@Test
	public void findbyIdTest() {
		int dId=1;
		when(doctorRepository.findById(dId)).thenReturn(d1);
		
		//use case 1: contact valid
				try {
					assertEquals(d1, doctorRepository.findById(dId));
				} catch (RuntimeException e) { }
				
				dId = 2;
				try {
					assertEquals(d1, doctorRepository.findById(dId));
				} catch (RuntimeException e) {
					assertEquals("Invalid ID...", e.getMessage());
				}
				
	}

}
