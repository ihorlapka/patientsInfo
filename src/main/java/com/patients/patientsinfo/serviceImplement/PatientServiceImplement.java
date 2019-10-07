package com.patients.patientsinfo.serviceImplement;

import com.patients.patientsinfo.model.Patient;
import com.patients.patientsinfo.repository.PatientRepository;
import com.patients.patientsinfo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImplement implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        return null;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findOne(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public void registerNewPatient(Patient patient) {
        if (patient.getSex().equals("MALE")){
            patient.setIcon("images/male.jpg");
        }
        else if (patient.getSex().equals("FEMALE")){
            patient.setIcon("images/female.jpg");
        }
        else {
            patient.setIcon("images/others.png");
        }
        patientRepository.save(patient);
    }
}
