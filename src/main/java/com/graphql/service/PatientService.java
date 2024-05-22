package com.graphql.service;

import java.util.List;
import java.util.Optional;

import com.graphql.dto.PatientInput;
import com.graphql.entity.Patient;

public interface PatientService {

	List<Patient> getall();

	Optional<Patient> patientById(int id);

	String addPatient(PatientInput patient);

}
