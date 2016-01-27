package com.sbp.sambalpurandroidapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mukesh on 17/1/16.
 */
public class FestivalDetailActivity extends AppCompatActivity {

    // toobar items
    ImageView alert_bell_icon;
    boolean isNotificationAvailable = false;
    BroadcastReceiver mMessageReceiver;
    //    int backButtonCount_forAppClosing = 0;
    String strNotification_count = "";

    TextView fid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_details);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        fid = (TextView) findViewById(R.id.txt_fname);

        String f_id =  getIntent().getStringExtra("festival_id");
        fid.setText(f_id);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // reciever class

        mMessageReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // Get extra data included in the Intent
                strNotification_count = ""+Common.notification_count;
                if (Common.notification_count == 0){
                    isNotificationAvailable = false;
                }else{
                    isNotificationAvailable = true;
                }
                invalidateOptionsMenu();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("validateMenu"));
        Common.isActivityVisible = true;
        strNotification_count = ""+Common.notification_count;
        if (Common.notification_count == 0){
            isNotificationAvailable = false;
        }else{
            isNotificationAvailable = true;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem menuItem = menu.findItem(R.id.notification);
        MenuItemCompat.setActionView(menuItem, R.layout.alert_text_layout);
        RelativeLayout rl_notifyCount = (RelativeLayout) MenuItemCompat.getActionView(menuItem);

        View image = menu.findItem(R.id.notification).getActionView();
        alert_bell_icon = (ImageView) image.findViewById(R.id.alert_icon);
        alert_bell_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                alert_bell_icon.setClickable(false);
                Toast.makeText(getApplicationContext(), "Showing Notifications...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), CustomNotificationActivity.class));
            }
        });
        TextView cart_text = (TextView) rl_notifyCount.findViewById(R.id.alert_text);
        if(isNotificationAvailable) {
            cart_text.setVisibility(View.VISIBLE);
            cart_text.setText(strNotification_count);
            System.out.println("notification count :"+strNotification_count);
        }else{
            cart_text.setVisibility(View.INVISIBLE);
        }
        invalidateOptionsMenu();
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home ){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),"Your pressed settings",Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.search){
            Toast.makeText(getApplicationContext(),"Searching...",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.notification){
            Toast.makeText(getApplicationContext(), "Pressed on alert", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (Common.backButtonCount_forAppClosing >= 1) {
            finish();
        }else {
            Common.backButtonCount_forAppClosing++;
            Toast.makeText(getApplicationContext(), "Press again to close the app", Toast.LENGTH_LONG).show();
        }
    }
}
