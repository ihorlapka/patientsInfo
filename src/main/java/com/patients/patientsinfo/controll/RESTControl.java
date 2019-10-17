package com.patients.patientsinfo.controll;

import com.patients.patientsinfo.model.Patient;
import com.patients.patientsinfo.model.PatientDTO;
import com.patients.patientsinfo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RESTControl {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientService.findAll();
    }

    @PostMapping("/addPatient")
    public void addPatient (@RequestBody PatientDTO patient){
        patientService.registerNewPatient(patient);
    }

    @PostMapping("/deletePat/{id}")
    public void deletePat(@PathVariable Long id){
        patientService.deletePatient(id);
    }

    @PostMapping("/editPatient")
    public void editPatient(@ModelAttribute(name = "patient") PatientDTO patient){
        if (patient.getSex()== Patient.Sex.MALE){
            patient.setIcon("images/male.jpg");
        }else if (patient.getSex()== Patient.Sex.FEMALE){
            patient.setIcon("images/female.jpg");
        }else patient.setIcon("images/others.png");
        patientService.update(patient);
    }

    @GetMapping("/findPatient")
    public Optional<Patient> findPatient(@PathVariable Long id){
        return patientService.findOne(id);
    }

}
