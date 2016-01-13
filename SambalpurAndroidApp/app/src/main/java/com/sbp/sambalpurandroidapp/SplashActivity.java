package com.sbp.sambalpurandroidapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

/**
 * Created by mukesh on 7/1/16.
 */
public class SplashActivity extends Activity {

    int SPLASH_TIME_OUT = 8000;
//    ActionBar actionBar;
    Intent myIntent;
    Boolean isUpdateAvailable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_splash);

        // Block orientation
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Hide Action Bar
//        actionBar = SplashActivity.this.getActionBar();
//        actionBar.hide();

        // Display splash screen and look if update is available ??
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isUpdateAvailable){
                    myIntent = new Intent(SplashActivity.this,UpdateActivity.class);
                    startActivity(myIntent);
                    finish();
                }else{
                    myIntent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(myIntent);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }


}
