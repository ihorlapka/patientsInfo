package com.patients.patientsinfo.controll;

import com.patients.patientsinfo.exceptions.PatientNotFoundException;
import com.patients.patientsinfo.model.Comment;
import com.patients.patientsinfo.model.Patient;
import com.patients.patientsinfo.model.PatientDTO;
import com.patients.patientsinfo.repository.CommentRepository;
import com.patients.patientsinfo.repository.PatientRepository;
import com.patients.patientsinfo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
public class MainController {

    private PatientService patientService;
    private PatientRepository patientRepository;
    private CommentRepository commentRepository;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
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
            patient.setIcon("images/male.jpg");
        }else if (patient.getSex()== Patient.Sex.FEMALE){
            patient.setIcon("images/female.jpg");
        }else patient.setIcon("images/others.png");
        patientService.update(patient);
        return "index";
    }

    @PostMapping("/addComment/{id}")
    public String addComment(@PathVariable(name = "id") Patient patient, @RequestParam(name = "comment") String text){
        System.out.println("Comment Patient id = "+patient.getId());
        Comment comment = new Comment();
        comment.setContext(text);
        comment.setPatient(patientService.findOne(patient.getId()).orElseThrow(PatientNotFoundException::new));
        LocalDate date = LocalDate.now();
        comment.setPostedDate(date);
        commentRepository.save(comment);
        return "redirect:/changes/"+patient.getId();
    }
}
