package com.patients.patientsinfo.controll;

import com.patients.patientsinfo.model.Patient;
import com.patients.patientsinfo.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RESTControl {

    private final PatientRepository patientRepository;

    public RESTControl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @PostMapping("/addPatient")
    void addPatient (@RequestBody Patient patient){
        patientRepository.save(patient);
    }


}
