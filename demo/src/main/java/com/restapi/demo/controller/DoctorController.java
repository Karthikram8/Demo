package com.restapi.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demo.model.Doctor;
import com.restapi.demo.model.User;
import com.restapi.demo.service.AuthService;
import com.restapi.demo.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/add/{userId}")
	private Doctor addDoctor(@PathVariable int userId, @RequestBody Doctor doctor) {
		
		User user =  authService.findById(userId);
		doctor.setUser(user);
		
		return doctorService.addDoctor(doctor);
	}

}
