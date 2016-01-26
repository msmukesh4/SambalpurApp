package com.sbp.sambalpurandroidapp;

/**
 * Created by mukesh on 26/1/16.
 */

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONObject;

public class AppReceiver extends ParsePushBroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        try{
            System.out.println(context +" "+ intent);
            // when the push is received through custom notification

            JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
            Log.d(TAG, json.getString("alert").toString());

//            final String notificationTitle = json.getString("title").toString();
            final String notificationContent = json.getString("alert").toString();
//            final String uri = json.getString("uri");

            Intent resultIntent = null;
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);


            resultIntent = new Intent(context, MainActivity.class);
            stackBuilder.addParentStack(MainActivity.class);

            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);


            //Customize your notification - sample code
            // application is visibleisActivityVisible
            if(Common.isActivityVisible){
                Common.notification_count++;
                Intent i = new Intent("validateMenu");
                LocalBroadcastManager.getInstance(context).sendBroadcast(i);


            }else {
                // application is in background
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(context)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Default Title")
                                .setContentText(notificationContent);

                int mNotificationId = 001;
                NotificationManager mNotifyMgr =
                        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                mNotifyMgr.notify(mNotificationId, builder.build());
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

}