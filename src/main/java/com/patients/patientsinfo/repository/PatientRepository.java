package com.patients.patientsinfo.repository;

import com.patients.patientsinfo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findAllByLastNameStartingWithOrFirstNameStartingWith(String lastName, String firstName);
}