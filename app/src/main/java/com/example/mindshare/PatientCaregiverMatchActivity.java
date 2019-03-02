package com.example.mindshare;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.mindshare.model.ApplicationState;
import com.example.mindshare.model.Caregiver;
import com.example.mindshare.model.Patient;

public class PatientCaregiverMatchActivity extends AppCompatActivity {

    private ApplicationState<Patient> appState = ApplicationState.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_caregiver_match);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Patient patient = (Patient) appState.getLoggedInUser();

        String caregiverName = patient.getCaregiver().getFullName();

        TextView caregiverNameTextView = findViewById(R.id.caregiver_name);
        caregiverNameTextView.setText(caregiverName);
    }

}
