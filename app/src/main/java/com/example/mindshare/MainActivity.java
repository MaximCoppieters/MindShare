package com.example.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.example.mindshare.repo.CaregiverRepository;
import com.example.mindshare.repo.PatientRepository;

public class MainActivity extends AppCompatActivity {

    private CaregiverRepository caregiverRepository;
    private PatientRepository patientRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        caregiverRepository = CaregiverRepository.getInstance();
        patientRepository = PatientRepository.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RelativeLayout caretakerSide = findViewById(R.id.supportive_side);
        RelativeLayout patientSide = findViewById(R.id.patient_side);

        caretakerSide.setOnClickListener((view)-> {
            startActivity(new Intent(MainActivity.this, PatientListActivity.class));
        });

        patientSide.setOnClickListener((view)-> {
            startActivity(new Intent(MainActivity.this, ConnectCaregiverActivity.class));
        });

        ImageButton panicbutton = findViewById(R.id.panicbutton);
        panicbutton.setOnClickListener((view) -> {
            Intent intent = new Intent(this, HelpRequestActivity.class);

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
