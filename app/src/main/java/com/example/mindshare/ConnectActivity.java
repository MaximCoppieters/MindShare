package com.example.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mindshare.model.Caregiver;
import com.example.mindshare.repo.CaregiverRepository;

import java.util.List;
import java.util.zip.Inflater;

public class ConnectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button connectButton = findViewById(R.id.connect_button);

        connectButton.setOnClickListener(view -> {
            TextView caregiverTextView = findViewById(R.id.caregiver_id);

            String caregiverId = caregiverTextView.getText().toString();

            CaregiverRepository caregiverRepository = new CaregiverRepository();
            List<Caregiver> caregivers = caregiverRepository.getAll();

            if (careGiverIdExists(caregiverId, caregivers)) {
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

}
