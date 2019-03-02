package com.example.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mindshare.model.ApplicationState;
import com.example.mindshare.model.Caregiver;
import com.example.mindshare.model.Patient;
import com.example.mindshare.repo.CaregiverRepository;

import java.util.List;

public class ConnectCaregiverActivity extends AppCompatActivity {

    private ApplicationState<Patient> appState = ApplicationState.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appState.setUserType(Patient.class);

        Button connectButton = findViewById(R.id.connect_button);

        connectButton.setOnClickListener(view -> {
            TextView caregiverIdTextView = findViewById(R.id.caregiver_id);

            String caregiverId = caregiverIdTextView.getText().toString();

            CaregiverRepository caregiverRepository = CaregiverRepository.getInstance();
            List<Caregiver> caregivers = caregiverRepository.getAll();

            if (careGiverIdExists(caregiverId, caregivers)) {
                Patient loggedInPatient = (Patient) appState.getLoggedInUser();
                Caregiver matchedCareGiver = getCareGiverOfId(caregiverId, caregivers);

                matchedCareGiver.addPatient(loggedInPatient);
                loggedInPatient.setCaregiver(matchedCareGiver);

                appState.setLoggedInUser(loggedInPatient);

                System.err.println(matchedCareGiver);
                System.err.println(loggedInPatient);

                Intent intent = new Intent(this, PatientCaregiverMatchActivity.class);
                startActivity(intent);
            } else {
                TextView notFoundWarningTextView = findViewById(R.id.caregiver_not_found_warning);
                notFoundWarningTextView.setVisibility(View.VISIBLE);
            }
        });

    }

    private boolean careGiverIdExists(String caregiverId, List<Caregiver> caregivers) {
        return caregivers.stream()
                .anyMatch(caregiver -> caregiver.getId().equals(caregiverId));
    }

    private Caregiver getCareGiverOfId(String caregiverId, List<Caregiver> caregivers) {
        return caregivers.stream()
                .findFirst()
                .get();
    }
}
