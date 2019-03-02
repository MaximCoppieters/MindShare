package com.example.mindshare.model;

public class Patient extends User {

    private Caregiver caregiver;

    public Patient(String firstName, String lastName, String password) {
        super(firstName, lastName, password);
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }
}
