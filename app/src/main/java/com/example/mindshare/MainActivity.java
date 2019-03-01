package com.example.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.mindshare.model.Caregiver;
import com.example.mindshare.repo.CaregiverRepository;
import com.example.mindshare.repo.PatientRepository;

public class MainActivity extends AppCompatActivity {

private CaregiverRepository caregiverRepository;
private PatientRepository patientRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        caregiverRepository = new CaregiverRepository();
        patientRepository = new PatientRepository();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       ImageView careTaker = findViewById(R.id.supportiveSide);
        careTaker.setOnClickListener((view)-> {
            caregiverRepository = caregiverRepository.getInstance();
            startActivity(new Intent(MainActivity.this, CareTakerHome.class));

        });

        findViewById(R.id.patientSide).setOnClickListener((view)->{
            patientRepository = patientRepository.getInstance();
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
