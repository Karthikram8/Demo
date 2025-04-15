package com.restapi.demo.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DoctorPatient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Doctor doctor;
	
	@ManyToOne
	private Patient patient;
	
	@Column(nullable = false)
	private LocalDateTime appointmentSchedule;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public LocalDateTime getAppointmentSchedule() {
		return appointmentSchedule;
	}

	public void setAppointmentSchedule(LocalDateTime appointmentSchedule) {
		this.appointmentSchedule = appointmentSchedule;
	}
	
	public DoctorPatient(int id, Doctor doctor, Patient patient, LocalDateTime appointmentSchedule) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentSchedule = appointmentSchedule;
	}

	public DoctorPatient() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointmentSchedule, doctor, id, patient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoctorPatient other = (DoctorPatient) obj;
		return Objects.equals(appointmentSchedule, other.appointmentSchedule) && Objects.equals(doctor, other.doctor)
				&& id == other.id && Objects.equals(patient, other.patient);
	}

	
	
	
}
