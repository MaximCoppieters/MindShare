package com.example.mindshare;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.pm.PackageManager;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;


import com.example.mindshare.model.Caregiver;
import com.example.mindshare.repo.CaregiverRepository;
import com.example.mindshare.repo.PatientRepository;

public class MainActivity extends AppCompatActivity {

    private CaregiverRepository caregiverRepository;
    private PatientRepository patientRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startActivity(new Intent(MainActivity.this, ConnectCaregiverActivity.class));
        caregiverRepository = new CaregiverRepository();
        patientRepository = new PatientRepository();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView caretakerSide = findViewById(R.id.supportiveSide);
        ImageView patientSide = findViewById(R.id.patientSide);

        caretakerSide.setOnClickListener((view)-> {
            startActivity(new Intent(MainActivity.this, PatientListActivity.class));
        });

        patientSide.setOnClickListener((view)-> {
            startActivity(new Intent(MainActivity.this, ConnectCaregiverActivity.class));

        });

        findViewById(R.id.patientSide).setOnClickListener((view)->{
            patientRepository = patientRepository.getInstance();
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
