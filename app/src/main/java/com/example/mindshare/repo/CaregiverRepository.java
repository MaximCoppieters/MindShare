package com.example.mindshare.repo;

import com.example.mindshare.R;
import com.example.mindshare.model.ApplicationState;
import com.example.mindshare.model.Caregiver;
import com.example.mindshare.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class CaregiverRepository {
    private static final CaregiverRepository instance = new CaregiverRepository();

    public static CaregiverRepository getInstance() {
        return instance;
    }

    public List<Caregiver> getAll() {
        List<Caregiver> caregivers = new ArrayList<>();

        PatientRepository patientRepository = PatientRepository.getInstance();
        List<Patient> patients = patientRepository.getPatients();


        Caregiver caregiver1 = new Caregiver("John", "Doe", "password");
        Caregiver caregiver2 = new Caregiver("Jane", "Roe", "password");

        caregiver1.setId("4eaada5");
        caregiver2.setId("5da6a66");

        ApplicationState state = ApplicationState.getInstance();

        state.setUserType(Caregiver.class);

        for (int i = 0; i < 3; i++) {
            patients.get(i).setCaregiver(caregiver1);
            patients.get(i).setCaregiver(caregiver2);
        }

        caregiver1.setImageId(R.drawable.caregiver1);
        caregiver2.setImageId(R.drawable.caregiver2);

        caregivers.add(caregiver1);
        caregivers.add(caregiver2);


        return caregivers;
    }
}
