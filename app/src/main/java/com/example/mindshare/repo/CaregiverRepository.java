package com.example.mindshare.repo;

import com.example.mindshare.model.Caregiver;

import java.util.ArrayList;
import java.util.List;

public class CaregiverRepository {
    private static final CaregiverRepository instance = new CaregiverRepository();

    public CaregiverRepository getInstance() {
        return instance;
    }

    public List<Caregiver> getCaregivers() {
        List<Caregiver> patients = new ArrayList<>();

        patients.add(new Caregiver("4eaada5", "Doe", "password"));
        patients.add(new Caregiver("5da6a66", "Roe", "password"));
        patients.add(new Caregiver("525aad4", "Smith", "password"));
        patients.add(new Caregiver("adz6azd", "Smith", "password"));
        patients.add(new Caregiver("5645a45", "Smith", "password"));

        return patients;
    }
}
