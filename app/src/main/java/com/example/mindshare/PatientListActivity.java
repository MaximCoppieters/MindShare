package com.example.mindshare;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mindshare.model.Patient;
import com.example.mindshare.repo.PatientRepository;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PatientListActivity extends AppCompatActivity {

    private List<Patient> patients;
    private PatientRepository patientRepository = new PatientRepository();
    private RecyclerView patientsRecyclerView;
    private PatientAdapter patientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);
        Toolbar toolbar = findViewById(R.id.toolbar);

        patientsRecyclerView = findViewById(R.id.patients);
        initializePatients();

        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initializePatients() {
        patients = patientRepository.getPatients();

        patientAdapter = new PatientAdapter(patients);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        patientsRecyclerView.setLayoutManager(layoutManager);
        patientsRecyclerView.setAdapter(patientAdapter);
    }

    private class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

        private List<Patient> patients;

        public PatientAdapter(List<Patient> patients) {
            this.patients = patients;
        }

        @NonNull
        @Override
        public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.row_patient_select, viewGroup, false);
            return new PatientViewHolder(view);
        }

        @Override
        public int getItemCount() {
            return patients.size();
        }

        @Override
        public void onBindViewHolder(@NonNull final PatientViewHolder patientViewHolder, final int position) {
            final Patient selectedPatient = PatientListActivity.this.patients.get(position);

            patientViewHolder.patient_name.setText(selectedPatient.getFullName());
            patientViewHolder.patient_image.setImageResource(selectedPatient.getImageId());

            Picasso.get().load(selectedPatient.getImageId()).into(patientViewHolder.patient_image);

            patientViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    
                }
            });
        }

        public class PatientViewHolder extends RecyclerView.ViewHolder {
            public TextView patient_name;
            public ImageView patient_image;

            public PatientViewHolder(@NonNull View itemView) {
                super(itemView);
                patient_name = itemView.findViewById(R.id.patient_name);
                patient_image = itemView.findViewById(R.id.patient_image);
            }
        }
    }

}
