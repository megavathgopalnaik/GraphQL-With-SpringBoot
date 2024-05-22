package com.graphql.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import com.graphql.dto.DoctorAddedEvent;
import com.graphql.dto.DoctorInput;
import com.graphql.entity.Doctor;
import com.graphql.service.DoctorService;

import reactor.core.publisher.Flux;

@Controller
public class DoctorApi {
	
	@Autowired
	private DoctorService doctorService;
	
  @QueryMapping("doctorall")
  public List<Doctor> getAll() {
	  
	  return doctorService.getall();
  }
  
    @QueryMapping("doctorById")
    public Optional<Doctor>getById(@Argument int id){
    	 return doctorService.getById(id);
    }
    
    @MutationMapping
    public String addDoctor(@Argument DoctorInput doctor) {
    	
    	return doctorService.addDoctor(doctor);
    }
    
    @MutationMapping
 public String updateDoctor(@Argument int id, @Argument DoctorInput doctor) {
    	
    	return doctorService.updateDoctor(id,doctor);
    }
}