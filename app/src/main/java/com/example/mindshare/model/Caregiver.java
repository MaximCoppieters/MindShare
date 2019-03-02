package com.example.mindshare.model;

import java.util.ArrayList;
import java.util.List;

public class Caregiver extends User {

    private List<Patient> patients;
    private String id;

    public Caregiver(String firstName, String lastName, String password) {
        super(firstName, lastName, password);
        patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
