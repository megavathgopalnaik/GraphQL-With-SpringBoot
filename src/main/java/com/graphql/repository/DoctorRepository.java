package com.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
