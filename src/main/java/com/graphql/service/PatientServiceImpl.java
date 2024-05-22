package com.graphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.dto.PatientInput;
import com.graphql.entity.Doctor;
import com.graphql.entity.Patient;
import com.graphql.repository.DoctorRepository;
import com.graphql.repository.PatientRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private DoctorRepository doctorRepo;
	@Override
	public List<Patient> getall() {
		
		return patientRepo.findAll();
	}
	@Override
	public Optional<Patient> patientById(int id) {
		// TODO Auto-generated method stub
		Optional<Patient> patient=patientRepo.findById(id);
		return patient;
	}
	@Override
	public String addPatient(PatientInput patient) {
		// TODO Auto-generated method stub
		Patient patientn=new Patient();
		patientn.setAge(patient.age());
		patientn.setDisease(patient.disease());
       Optional<Doctor> d= doctorRepo.findById(patient.doctorId());
		Doctor doctor=d.get();
		patientn.setDoctor(doctor);
		patientn.setName(patient.name());
		Patient pat= patientRepo.save(patientn);
		String id=String.valueOf(pat.getId());
		return "patient added successfully and id is "+id;
	}}