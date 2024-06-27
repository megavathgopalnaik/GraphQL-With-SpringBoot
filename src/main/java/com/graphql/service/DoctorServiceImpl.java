package com.graphql.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.dto.DoctorInput;
import com.graphql.entity.Doctor;

import com.graphql.repository.DoctorRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	
	@Override
	public List<Doctor> getall() {

		return  doctorRepository.findAll();
	}




	@Override
	public Optional<Doctor> getById(int id) {
		Optional<Doctor> doctor=doctorRepository.findById(id);
		return doctor;
	}







	@Override
	public String addDoctor(DoctorInput doctor) {
		Doctor doctorn = new Doctor();
		doctorn.setAge(doctor.age());
		doctorn.setDegree(doctor.degree());
		doctorn.setDepartment(doctor.department());
		doctorn.setName(doctor.name());
		Doctor newDoctor=doctorRepository.save(doctorn);
		int id = newDoctor.getId();
		String idString = String.valueOf(id);

		return "Doctor Added Successfully and the id is "+idString;
	}




	@Override
	public String updateDoctor(int id, DoctorInput doctor) {
		// TODO Auto-generated method stub
		Optional<Doctor> doct= doctorRepository.findById(id);
		Doctor doctorn= doct.get();
		doctorn.setAge(doctor.age());
		doctorn .setDegree(doctor.degree());
		doctorn.setDepartment(doctor.department());
		doctorn.setName(doctor.name());
		doctorRepository.save(doctorn);
		
		return "Doctor Updated Successfully";
	}
	
}
