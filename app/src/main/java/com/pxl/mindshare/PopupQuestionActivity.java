package com.pxl.mindshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pxl.mindshare.business.ApplicationState;
import com.pxl.mindshare.model.Patient;
import com.pxl.mindshare.repo.FeelingsRepository;

import java.util.HashMap;
import java.util.Map;

public class PopupQuestionActivity extends AppCompatActivity {

    private FeelingsRepository feelingsRepository;
    private ApplicationState<Patient> appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_question);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        feelingsRepository = FeelingsRepository.getInstance();
        appState = ApplicationState.getInstance();
    }

    // EventHandler for color image items
    public void checkColor(View view) {
        int chosenColorId = view.getId();

        Map<Integer, String> colorNamesByColorId = fetchColorNamesById();

        String chosenColorName = colorNamesByColorId.get(chosenColorId);

        String chosenColorFeeling = feelingsRepository.getColorFeeling(chosenColorName);

        appState.setChosenColorDescription(chosenColorFeeling);
        appState.setChosenColorName(chosenColorName);

        startActivity(new Intent(PopupQuestionActivity.this, ColorFeelingActivity.class));
    }

    public Map<Integer, String> fetchColorNamesById() {
        Map<Integer, String> colorNameById = new HashMap<>();

        colorNameById.put(R.id.black, "black");
        colorNameById.put(R.id.blue, "blue");
        colorNameById.put(R.id.green, "green");
        colorNameById.put(R.id.red, "red");
        colorNameById.put(R.id.pink, "pink");
        colorNameById.put(R.id.yellow, "yellow");
        colorNameById.put(R.id.purple, "purple");
        colorNameById.put(R.id.cyan, "cyan");
        colorNameById.put(R.id.grey, "grey");

        return colorNameById;
    }
}
