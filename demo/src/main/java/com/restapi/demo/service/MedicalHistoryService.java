package com.restapi.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.demo.model.MedicalHistory;
import com.restapi.demo.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {

	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
	
	public MedicalHistory addMedicaHistory(MedicalHistory medicalHistory) {
		// TODO Auto-generated method stub
		return medicalHistoryRepository.save(medicalHistory);
	}

	public MedicalHistory findById(int medHisId) {
		Optional<MedicalHistory> optional = medicalHistoryRepository.findById(medHisId);
		if(optional.isEmpty())
			throw new RuntimeException("Invalid MedicalHistory Id...");
		return optional.get();
	}

}
