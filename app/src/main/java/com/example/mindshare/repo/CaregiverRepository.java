package com.example.mindshare.repo;

import com.example.mindshare.R;
import com.example.mindshare.model.Caregiver;

import java.util.ArrayList;
import java.util.List;

public class CaregiverRepository {
    private static final CaregiverRepository instance = new CaregiverRepository();

    public CaregiverRepository getInstance() {
        return instance;
    }

    public List<Caregiver> getCaregivers() {
        List<Caregiver> caregivers = new ArrayList<>();

        Caregiver caregiver1 = new Caregiver("4eaada5", "Doe", "password");
        Caregiver caregiver2 = new Caregiver("5da6a66", "Roe", "password");
        Caregiver caregiver3 = new Caregiver("525aad4", "Smith", "password");
        Caregiver caregiver4 = new Caregiver("adz6azd", "Smith", "password");
        Caregiver caregiver5 = new Caregiver("5645a45", "Smith", "password");


        caregiver1.setImageId(R.drawable.caregiver1);
        caregiver2.setImageId(R.drawable.caregiver2);
        caregiver3.setImageId(R.drawable.caregiver1);
        caregiver4.setImageId(R.drawable.caregiver2);
        caregiver5.setImageId(R.drawable.caregiver2);

        caregivers.add(caregiver1);
        caregivers.add(caregiver2);
        caregivers.add(caregiver3);
        caregivers.add(caregiver4);
        caregivers.add(caregiver5);


        return caregivers;
    }
}
