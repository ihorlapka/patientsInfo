package com.patients.patientsinfo.repository;

import com.patients.patientsinfo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
