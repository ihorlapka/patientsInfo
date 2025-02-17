package com.patients.patientsinfo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate postedDate;
    private String context;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private Patient patient;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", postedDate=" + postedDate +
                ", context='" + context + '\'' +
                '}';
    }
}
