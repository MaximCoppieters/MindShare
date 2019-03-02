package com.pxl.mindshare;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mapbox.android.core.permissions.PermissionsManager;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class HelpRequestActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private static final String TAG = "MainActivity";
    private PermissionsManager permissionsManager;
    private Button requestHelpButton;
    private Map<CardView, Boolean> feelingsCardViewsToggled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_request);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        requestHelpButton = findViewById(R.id.request_help_button);

        requestHelpButton.setOnClickListener(view -> {
            requestPermission();
            checkPermission();
            if (checkPermission()) {
                StringJoiner messageBuilder = new StringJoiner(", ");

                feelingsCardViewsToggled.forEach((feelingsCardView, toggled) -> {
                    TextView feelingsTextView = (TextView) feelingsCardView.getChildAt(0);

                    messageBuilder.add(feelingsTextView.getText().toString());
                });

                String smsMessage = messageBuilder.toString();

                smsSendMessage(view, smsMessage);
            }
        });

        getFeelingsCardViews();
        assignFeelingsCardViewColors();
    }

    private void getFeelingsCardViews() {
        feelingsCardViewsToggled = new HashMap<>();

        feelingsCardViewsToggled.put(findViewById(R.id.energyless), false);
        feelingsCardViewsToggled.put(findViewById(R.id.lonely), false);
        feelingsCardViewsToggled.put(findViewById(R.id.dark_thoughts), false);
    }

    public void toggleCardView(View view) {
        requestHelpButton.setVisibility(View.VISIBLE);

        CardView pressedCardView = findViewById(view.getId());

        feelingsCardViewsToggled.put(pressedCardView, !feelingsCardViewsToggled.get(pressedCardView));

        if (feelingsCardIsToggled()) {
            requestHelpButton.setVisibility(View.VISIBLE);
        } else {
            requestHelpButton.setVisibility(View.INVISIBLE);
        }

        assignFeelingsCardViewColors();

    }

    private void changeFeelingsCardColor(CardView cardview) {
        if (feelingsCardViewsToggled.get(cardview)) {
            switch (cardview.getId()) {
                case R.id.lonely:
                    cardview.setCardBackgroundColor(Color.rgb(225,0,0));
                    break;
                case R.id.energyless:
                    cardview.setCardBackgroundColor(Color.CYAN);
                    break;
                case R.id.dark_thoughts:
                    cardview.setCardBackgroundColor(Color.BLACK);
                    break;
            }
        } else {
            switch (cardview.getId()) {
                case R.id.lonely:
                    cardview.setCardBackgroundColor(Color.GRAY);
                    break;
                case R.id.energyless:
                    cardview.setCardBackgroundColor(Color.GRAY);
                    break;
                case R.id.dark_thoughts:
                    cardview.setCardBackgroundColor(Color.GRAY);
                    break;
            }
        }
    }

    private void assignFeelingsCardViewColors() {
        feelingsCardViewsToggled.forEach((cardview, toggled) -> {
            changeFeelingsCardColor(cardview);
        });
    }

    private boolean feelingsCardIsToggled() {
        return feelingsCardViewsToggled.containsValue(true);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(HelpRequestActivity.this, new String[]
                {
                        Manifest.permission.SEND_SMS
                }, MY_PERMISSIONS_REQUEST_SEND_SMS);
    }

    private boolean checkPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permission not granted");
            requestPermission();
            return false;
        } else {
            return true;
        }
    }

    public void smsSendMessage(View view, String message) {
        String smsNumber = "0498790525";
        String sms = message;
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
