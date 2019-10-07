package com.patients.patientsinfo.controll;

import com.patients.patientsinfo.model.Patient;
import com.patients.patientsinfo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/registration")
    public String register(Model model){
        model.addAttribute("patient", new Patient());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(name = "patient") Patient patient){
        patientService.registerNewPatient(patient);
        return "index";
    }
}
