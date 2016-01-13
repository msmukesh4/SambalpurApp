package com.sbp.sambalpurandroidapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by mukesh on 3/1/16.
 */
public class Festival extends AppCompatActivity {

    ListView festival_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival);
        festival_list = (ListView) findViewById(R.id.festival_list);

    }
}
