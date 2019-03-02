package com.pxl.mindshare.business;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.pxl.mindshare.PopupQuestionActivity;

import java.util.Timer;
import java.util.TimerTask;

public class PopupTimerTask extends TimerTask {
    private Context appContext;

    public PopupTimerTask(Context context) {
        this.appContext = context;
    }

    @Override
    public void run() {
        appContext.startActivity(new Intent(appContext, PopupQuestionActivity.class));
    }
}
