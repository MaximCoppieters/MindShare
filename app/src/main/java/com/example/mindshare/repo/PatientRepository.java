package com.example.mindshare.repo;

import com.example.mindshare.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientRepository {

    private static final PatientRepository instance = new PatientRepository();

    public PatientRepository getInstance() {
        return instance;
    }

    public List<Patient> getPatients() {
        List<Patient> patients = new ArrayList<>();

        patients.add(new Patient("John", "Doe", "password"));
        patients.add(new Patient("Jane", "Roe", "password"));
        patients.add(new Patient("Allen", "Smith", "password"));
        patients.add(new Patient("Allen", "Smith", "password"));
        patients.add(new Patient("Allen", "Smith", "password"));

        return patients;
    }
}
