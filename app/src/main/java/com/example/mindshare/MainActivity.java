package com.example.mindshare;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.mindshare.model.Caregiver;
import com.example.mindshare.repo.CaregiverRepository;
import com.example.mindshare.repo.PatientRepository;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private static final String TAG = "MainActivity";
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
            startActivity(new Intent(MainActivity.this, OptionsMenuCareTaker.class));

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

    public void smsSendMessage(View view) {
        String smsNumber = "0498790525";
        String sms = "Help";
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.setData(Uri.parse(smsNumber));
        smsIntent.putExtra("sms_body", sms);
        if (smsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(smsIntent);
        } else {
            Log.e(TAG, "Can't resolve app for ACTION_SENDTO Intent");
        }
        String scAddress = null;
        PendingIntent sentIntent = null, deliveryIntent = null;
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage
                (smsNumber, scAddress, sms,
                        sentIntent, deliveryIntent);
    }


}
