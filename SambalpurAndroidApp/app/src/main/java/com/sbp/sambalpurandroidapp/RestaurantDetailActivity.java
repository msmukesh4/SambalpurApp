package com.sbp.sambalpurandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by mukesh on 21/2/16.
 */
public class RestaurantDetailActivity extends AppCompatActivity {

    TextView rid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_details);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        rid = (TextView) findViewById(R.id.txt_fname);
        String r_id =  getIntent().getStringExtra("res_id");
        rid.setText(r_id);
        System.out.println("rid = " + r_id);
    }
}
