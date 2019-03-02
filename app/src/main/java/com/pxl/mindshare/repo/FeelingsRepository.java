package com.pxl.mindshare.repo;

import java.util.HashMap;
import java.util.Map;

public class FeelingsRepository {
    private static final FeelingsRepository instance = new FeelingsRepository();
    private Map<String, String> colorsByFeeling;

    public static FeelingsRepository getInstance() {
        return instance;
    }

    private FeelingsRepository() {
        colorsByFeeling = new HashMap<>();

    }

    private void initializeColorsByFeelings() {
        colorsByFeeling.put("black", "");
        colorsByFeeling.put("blue", "");
        colorsByFeeling.put("green", "");
        colorsByFeeling.put("red", "");
        colorsByFeeling.put("pink", "");
        colorsByFeeling.put("yellow", "");
        colorsByFeeling.put("purple", "");
        colorsByFeeling.put("cyan", "");
        colorsByFeeling.put("grey", "");
    }


    public String getColorFeeling(String chosenColorName) {
        return colorsByFeeling.get(chosenColorName);
    }
}
