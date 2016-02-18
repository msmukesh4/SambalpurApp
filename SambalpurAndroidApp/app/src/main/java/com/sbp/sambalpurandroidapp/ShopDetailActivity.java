package com.sbp.sambalpurandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by mukesh on 19/2/16.
 */
public class ShopDetailActivity extends AppCompatActivity {

    TextView sid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_details);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        sid = (TextView) findViewById(R.id.txt_fname);
        String f_id =  getIntent().getStringExtra("shop_id");
        sid.setText(f_id);
    }
}
