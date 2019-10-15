package com.patients.patientsinfo.exceptions;

public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException() {
        super("Patient not found!");
    }
}
