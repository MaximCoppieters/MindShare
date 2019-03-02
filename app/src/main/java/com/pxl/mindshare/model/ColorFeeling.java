package com.pxl.mindshare.model;

import java.util.Map;

public class ColorFeeling {
    private int colorId;
    private String associatedColor;

    public ColorFeeling(int colorId, String associatedColor) {
        this.colorId = colorId;
        this.associatedColor = associatedColor;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getAssociatedColor() {
        return associatedColor;
    }

    public void setAssociatedColor(String associatedColor) {
        this.associatedColor = associatedColor;
    }
}
