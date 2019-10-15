package com.patients.patientsinfo.serviceImplement;

import com.patients.patientsinfo.exceptions.PatientNotFoundException;
import com.patients.patientsinfo.model.Patient;
import com.patients.patientsinfo.model.PatientDTO;
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
    public Patient update(PatientDTO patientDTO) {
        System.out.println("Patient " + patientDTO.getFirstName()+" is going to be updated");
        Patient patient = findOne(patientDTO.getId()).orElseThrow(PatientNotFoundException::new);
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setAge(patientDTO.getAge());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setSex(patientDTO.getSex());
        patient.setCountry(patientDTO.getCountry());
        patient.setState(patientDTO.getState());
        patient.setAddress(patientDTO.getAddress());
        patient.setIcon(patientDTO.getIcon());
        return patientRepository.save(patient);
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
    public void registerNewPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setAge(patientDTO.getAge());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setSex(patientDTO.getSex());
        patient.setCountry(patientDTO.getCountry());
        patient.setState(patientDTO.getState());
        patient.setAddress(patientDTO.getAddress());

        if (patientDTO.getSex()==Patient.Sex.MALE){
            patientDTO.setIcon("images/male.jpg");
        }
        else if (patientDTO.getSex()==Patient.Sex.FEMALE){
            patientDTO.setIcon("images/female.jpg");
        }
        else {
            patientDTO.setIcon("images/others.png");
        }
        patient.setIcon(patientDTO.getIcon());
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }


}
