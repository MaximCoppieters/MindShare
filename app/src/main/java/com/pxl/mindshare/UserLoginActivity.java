package com.pxl.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pxl.mindshare.business.ApplicationState;
import com.pxl.mindshare.model.Caregiver;
import com.pxl.mindshare.model.Patient;
import com.pxl.mindshare.model.User;
import com.pxl.mindshare.repo.CaregiverRepository;
import com.pxl.mindshare.repo.PatientRepository;

import java.util.List;
import java.util.Optional;

public class UserLoginActivity extends AppCompatActivity {

    private ApplicationState appState = ApplicationState.getInstance();
    private CaregiverRepository caregiverRepository;
    private PatientRepository patientRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button loginButton = findViewById(R.id.login_button);
        TextView emailTextView = findViewById(R.id.email_text_box);
        TextView passwordTextView = findViewById(R.id.password_text_box);

        caregiverRepository = CaregiverRepository.getInstance();
        patientRepository = PatientRepository.getInstance();

        loginButton.setOnClickListener(view -> {
            resetWarningTextBoxes();
            String email = emailTextView.getText().toString();
            String password = passwordTextView.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                findViewById(R.id.login_empty_warning_text_box).setVisibility(View.VISIBLE);
            } else {
                List<Patient> patients = patientRepository.getAll();
                List<Caregiver> caregivers = caregiverRepository.getAll();

                Optional<Caregiver> caregiverOptional = getUserOptionalFromRepository(caregivers, email, password);

                if (caregiverOptional.isPresent()) {
                    appState.setLoggedInUser(caregiverOptional.get());

                    startActivity(new Intent(UserLoginActivity.this, MainActivity.class));
                } else {
                    Optional<Patient> patientOptional = getUserOptionalFromRepository(patients, email, password);

                    if (patientOptional.isPresent()) {
                        appState.setLoggedInUser(patientOptional.get());

                        startActivity(new Intent(UserLoginActivity.this, MainActivity.class));
                    } else {
                        findViewById(R.id.login_invalid_warning_text_box).setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        findViewById(R.id.user_login_activity_sign_up_button).setOnClickListener((view)->{
            startActivity(new Intent(UserLoginActivity.this, SignUpActivity.class));
        });
    }

    private void resetWarningTextBoxes() {
        findViewById(R.id.login_invalid_warning_text_box).setVisibility(View.VISIBLE);
        findViewById(R.id.login_empty_warning_text_box).setVisibility(View.VISIBLE);
    }

    private <T extends User> Optional<T> getUserOptionalFromRepository(List<T> users, String email, String password) {
        return users.stream().filter(user -> {
            return user.getEmail().equals(email) || user.getPassword().equals(password);
        }).findFirst();
    }

}
