package com.pxl.mindshare.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Caregiver extends User {

    private List<Patient> patients;
    private String id;

    public Caregiver(String firstName, String lastName, String password) {
        super(firstName, lastName, password);
        patients = new ArrayList<>();
    }

    public Caregiver(String firstName, String lastName, String password, String email) {
        super(firstName, lastName, password, email);
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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        return "Caregiver{" +
                "id='" + id + '\'' +
                '}';
    }
}
