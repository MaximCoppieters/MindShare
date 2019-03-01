package com.example.mindshare.repo;

import com.example.mindshare.R;
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

        Patient patient1 = new Patient("John", "Doe", "password");
        Patient patient2 = new Patient("Jane", "Roe", "password");
        Patient patient3 = new Patient("Allen", "Smith", "password");
        Patient patient4 = new Patient("Allen", "Smith", "password");
        Patient patient5 = new Patient("Allen", "Smith", "password");

        patient1.setImageId(R.drawable.patient1);
        patient1.setImageId(R.drawable.patient2);
        patient1.setImageId(R.drawable.patient3);
        patient1.setImageId(R.drawable.patient4);
        patient1.setImageId(R.drawable.patient5);

        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);
        patients.add(patient5);

        return patients;
    }
}
