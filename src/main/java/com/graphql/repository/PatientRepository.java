package com.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.graphql.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	@Query(value = "SELECT * FROM patient p WHERE p.doctor_id = :id", nativeQuery = true)
	List<Patient> findByDoctorId(@Param("id") int id);


}
