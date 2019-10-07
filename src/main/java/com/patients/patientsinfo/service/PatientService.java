package com.patients.patientsinfo.service;

import com.patients.patientsinfo.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    void save(Patient patient);
    Patient update(Patient patient);
    List<Patient> findAll();
    Optional<Patient> findOne(Long id);
    void registerNewPatient(Patient patient);

}
