package com.patients.patientsinfo.controll;

import com.patients.patientsinfo.exceptions.PatientNotFoundException;
import com.patients.patientsinfo.model.Comment;
import com.patients.patientsinfo.model.Patient;
import com.patients.patientsinfo.repository.CommentRepository;
import com.patients.patientsinfo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CommentControl {

    private CommentRepository commentRepository;
    private PatientService patientService;

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
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

    @PostMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable(name = "id")Comment comment){
        commentRepository.delete(comment);
        return "index";
    }
}
