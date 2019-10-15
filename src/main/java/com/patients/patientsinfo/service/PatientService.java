package com.patients.patientsinfo.service;

import com.patients.patientsinfo.model.Patient;
import com.patients.patientsinfo.model.PatientDTO;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    void save(Patient patient);
    Patient update(PatientDTO patientDTO);
    List<Patient> findAll();
    Optional<Patient> findOne(Long id);
    void registerNewPatient(PatientDTO patientDTO);
    void deletePatient(Long id);

}
