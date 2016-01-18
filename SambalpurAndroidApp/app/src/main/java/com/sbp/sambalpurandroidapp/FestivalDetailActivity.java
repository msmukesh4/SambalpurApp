package com.sbp.sambalpurandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by mukesh on 17/1/16.
 */
public class FestivalDetailActivity extends AppCompatActivity {
    TextView fid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_details);
        fid = (TextView) findViewById(R.id.txt_fname);

        String f_id =  getIntent().getStringExtra("festival_id");
        fid.setText(f_id);
    }
}
