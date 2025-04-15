package com.restapi.demo.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MedicalHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String illness;
	
	@Column(nullable = false)
	private int numOfYears;
	
	@Column(length = 1000)
	private String currentMedication;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public int getNumOfYears() {
		return numOfYears;
	}

	public void setNumOfYears(int numOfYears) {
		this.numOfYears = numOfYears;
	}

	public String getCurrentMedication() {
		return currentMedication;
	}

	public void setCurrentMedication(String currentMedication) {
		this.currentMedication = currentMedication;
	}

	public MedicalHistory(int id, String illness, int numOfYears, String currentMedication) {
		super();
		this.id = id;
		this.illness = illness;
		this.numOfYears = numOfYears;
		this.currentMedication = currentMedication;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currentMedication, id, illness, numOfYears);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalHistory other = (MedicalHistory) obj;
		return Objects.equals(currentMedication, other.currentMedication) && id == other.id
				&& Objects.equals(illness, other.illness) && numOfYears == other.numOfYears;
	}
	
	
	
}
