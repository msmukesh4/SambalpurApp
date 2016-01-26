package com.sbp.sambalpurandroidapp;

/**
 * Created by mukesh on 26/1/16.
 */
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by system15 on 11/14/2015.
 */
public class CustomNotificationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView tv  = (TextView) findViewById(R.id.textView);
        tv.setText("No. of notifications : "+Common.notification_count);
        Common.notification_count = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alert, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home ){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Your pressed settings", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.search){
            Toast.makeText(getApplicationContext(),"Searching...",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
