package com.graphql.service;

import java.util.List;
import java.util.Optional;

import com.graphql.dto.DoctorInput;
import com.graphql.entity.Doctor;

public interface DoctorService {

	List<Doctor> getall();

	Optional<Doctor> getById(int id);

	String addDoctor(DoctorInput doctor);

	String updateDoctor(int id, DoctorInput doctor);

	
	
	
	

}
