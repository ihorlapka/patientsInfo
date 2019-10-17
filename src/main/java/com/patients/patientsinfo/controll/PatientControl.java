package com.patients.patientsinfo.controll;

import com.patients.patientsinfo.exceptions.PatientNotFoundException;
import com.patients.patientsinfo.model.Patient;
import com.patients.patientsinfo.model.PatientDTO;
import com.patients.patientsinfo.repository.CommentRepository;
import com.patients.patientsinfo.repository.PatientRepository;
import com.patients.patientsinfo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientControl {


    private PatientService patientService;
    private PatientRepository patientRepository;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }



    @GetMapping({"/", "/index"})
    public String index(Model model){
        model.addAttribute("patients", patientService.findAll());
        return "index";
    }

    @GetMapping("/registration")
    public String register(Model model){
        model.addAttribute("patient", new Patient());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(name = "patient") PatientDTO patient){
        patientService.registerNewPatient(patient);
        return "index";
    }

    @PostMapping("/")
    public String search(@ModelAttribute(name = "search") String search, Model model){
        model.addAttribute("searchedPatient", patientRepository
                .findAllByLastNameStartingWithOrFirstNameStartingWith(search, search));
        return "index";
    }

    @PostMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return "index";
    }

    @GetMapping("/changes/{id}")
    public String changes(Model model, @PathVariable(value = "id") Patient patient){
        model.addAttribute("patient", patientService.findOne(patient.getId())
                .orElseThrow(PatientNotFoundException::new));
        return "changes";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(@ModelAttribute(name = "patient") PatientDTO patient){
        System.out.println("Patient id = "+patient.getId());
        if (patient.getSex()== Patient.Sex.MALE){
            patient.setIcon("./../../assets/male.jpg");
        }else if (patient.getSex()== Patient.Sex.FEMALE){
            patient.setIcon("./../../assets/female.jpg");
        }else patient.setIcon("./../../assets/others.png");
        patientService.update(patient);
        return "index";
    }
}
