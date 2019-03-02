package com.pxl.mindshare.repo;

import com.pxl.mindshare.R;
import com.pxl.mindshare.model.ApplicationState;
import com.pxl.mindshare.model.Caregiver;
import com.pxl.mindshare.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class CaregiverRepository {
    private static final CaregiverRepository instance = new CaregiverRepository();

    public static CaregiverRepository getInstance() {
        return instance;
    }

    private CaregiverRepository() {}

    public List<Caregiver> getAll() {
        List<Caregiver> caregivers = new ArrayList<>();

        PatientRepository patientRepository = PatientRepository.getInstance();
        List<Patient> patients = patientRepository.getAll();

        Caregiver caregiver1 = new Caregiver("Tina", "Ross", "password", "tinaross@gmail.com");
        Caregiver caregiver2 = new Caregiver("Roger", "Guy", "password", "rogerguy@gmail.com");

        caregiver2.setId("1234");
        caregiver1.setId("1234");

        ApplicationState state = ApplicationState.getInstance();

        state.setUserType(Caregiver.class);

        for (int i = 0; i < 3; i++) {
            patients.get(i).setCaregiver(caregiver2);
            patients.get(i).setCaregiver(caregiver1);
        }

        caregiver1.setImageId(R.drawable.caregiver1);
        caregiver2.setImageId(R.drawable.caregiver2);

        caregivers.add(caregiver1);
        caregivers.add(caregiver2);


        return caregivers;
    }
}
