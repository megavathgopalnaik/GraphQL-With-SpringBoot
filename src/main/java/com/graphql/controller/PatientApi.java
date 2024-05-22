package com.graphql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.dto.PatientInput;
import com.graphql.entity.Patient;
import com.graphql.service.PatientService;

@Controller

public class PatientApi {
	
	@Autowired
	private PatientService patientService;
	
	@QueryMapping("patientall")
	public List<Patient> getall(){
		
		return patientService.getall();
	}
	
	
	  @QueryMapping // also call with method name
	    public Optional<Patient>patientById(@Argument int id){
	    	 return patientService.patientById(id);
	    }

	  
	    @MutationMapping
	    public String addPatient(@Argument PatientInput patient) {
	    	System.out.println(patient);
	    	return patientService.addPatient(patient);
	    }
}
