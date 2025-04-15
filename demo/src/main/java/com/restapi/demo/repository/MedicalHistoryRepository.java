package com.restapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.demo.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer> {

}
