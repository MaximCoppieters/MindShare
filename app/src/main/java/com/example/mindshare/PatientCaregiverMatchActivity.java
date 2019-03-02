package com.example.mindshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mindshare.model.ApplicationState;
import com.example.mindshare.model.Caregiver;
import com.example.mindshare.model.Patient;
import com.squareup.picasso.Picasso;

public class PatientCaregiverMatchActivity extends AppCompatActivity {

    private ApplicationState<Patient> appState = ApplicationState.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_caregiver_match);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Patient patient = (Patient) appState.getLoggedInUser();

        Caregiver caregiverAssigned = patient.getCaregiver();

        TextView caregiverNameTextView = findViewById(R.id.caregiver_name);
        caregiverNameTextView.setText(caregiverAssigned.getFullName());

        ImageView caregiverImageView = findViewById(R.id.caregiver_foto);
        Picasso.get().load(caregiverAssigned.getImageId()).into(caregiverImageView);

        Button startAssistanceButton = findViewById(R.id.start_assistance_button);

        startAssistanceButton.setOnClickListener(view -> {

        });
    }

}
