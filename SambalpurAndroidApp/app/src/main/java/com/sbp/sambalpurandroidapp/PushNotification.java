package com.sbp.sambalpurandroidapp;

/**
 * Created by mukesh on 26/1/16.
 */
import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class PushNotification extends Application {

    @Override
    public void onCreate ()
    {
        super.onCreate();
//		Parse.enableLocalDatastore(this);
        Parse.initialize(this, getString(R.string.ParseAppId), getString(R.string.ParseClientId));

        // his will not show the notification bur will allow the class to open the app
        ParseInstallation.getCurrentInstallation().saveInBackground();

//		//setup notification
//		PushService.setDefaultPushCallback(PushNotification.this, MainActivity.class);
//		ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}

