package com.pxl.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.pxl.mindshare.business.ApplicationState;
import com.pxl.mindshare.model.Patient;

public class ColorFeelingActivity extends AppCompatActivity {

    private ApplicationState<Patient> appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_feeling);
        Toolbar toolbar = findViewById(R.id.toolbar);

        appState = ApplicationState.getInstance();
        toolbar.setTitle("You chose color " + appState.getChosenColorName());
        setSupportActionBar(toolbar);
        appState.setPopupCompleted(true);

        TextView colorFeelingTextView = findViewById(R.id.color_feeling_textview);

        colorFeelingTextView.setText(appState.getChosenColorDescription());

        Button returnButton = findViewById(R.id.return_button);

        returnButton.setOnClickListener(view -> {
            startActivity(new Intent(ColorFeelingActivity.this, PersonalProgressionActivity.class));
        });
    }

}
