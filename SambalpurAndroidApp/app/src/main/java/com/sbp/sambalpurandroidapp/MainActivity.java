package com.sbp.sambalpurandroidapp;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView title1,title2,title3,title4,title5,title6,title7,title8,title9;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ll = (LinearLayout) findViewById(R.id.ll_layer1);

        // sending Json Req and receiving the items in the textview
        // loop for adding more textviews into the list
        final String[] more_home_title = {"FESTIVALS","SHOPPING","RESTURANTS & HOTELS","TOURISM","MOVIES","TAXI & TRAVELS","DOCTOR CONTACTS","EMERGENCY CONTACTS"};
        for(int i = 0; i< more_home_title.length;i++){
            TextView tv = new TextView(MainActivity.this);
            tv.setText(more_home_title[i]);
//            tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//            tv.setBackground(getResources().getDrawable(R.drawable.rounder_rectangle));
            tv.setTextAppearance(MainActivity.this, R.style.HomeText);
            LinearLayout combobox = new LinearLayout(this);
            combobox.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
            combobox.setOrientation(LinearLayout.HORIZONTAL);


            RelativeLayout darkerlayout = new RelativeLayout(this);
            darkerlayout.setLayoutParams(new RelativeLayout.LayoutParams(200, ViewGroup.LayoutParams.MATCH_PARENT));
            darkerlayout.setPadding(10, 10, 10, 10);

            RelativeLayout lighterlayout = new RelativeLayout(this);
            lighterlayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            lighterlayout.setPadding(10,20,10,20);
            lighterlayout.addView(tv);

            if(i == 0 || i%7 ==0) {
                darkerlayout.setBackgroundColor(getResources().getColor(R.color.darkRed));
                lighterlayout.setBackgroundColor(getResources().getColor(R.color.lightRed));
            }else if (i%7 == 1){
                darkerlayout.setBackgroundColor(getResources().getColor(R.color.darkBlue));
                lighterlayout.setBackgroundColor(getResources().getColor(R.color.lightBlue));
            }else if (i%7 == 2){
                darkerlayout.setBackgroundColor(getResources().getColor(R.color.darkGreen));
                lighterlayout.setBackgroundColor(getResources().getColor(R.color.lightGreen));
            }else if (i%7 == 3){
                darkerlayout.setBackgroundColor(getResources().getColor(R.color.darkViolet));
                lighterlayout.setBackgroundColor(getResources().getColor(R.color.lightViolet));
            }else if (i%7 == 4){
                darkerlayout.setBackgroundColor(getResources().getColor(R.color.darkBlue));
                lighterlayout.setBackgroundColor(getResources().getColor(R.color.lightBlue));
            }else if (i%7 == 5){
                darkerlayout.setBackgroundColor(getResources().getColor(R.color.darkBlack));
                lighterlayout.setBackgroundColor(getResources().getColor(R.color.lightBlack));
            }else{
                darkerlayout.setBackgroundColor(getResources().getColor(R.color.darkYellow));
                lighterlayout.setBackgroundColor(getResources().getColor(R.color.lightYellow));
            }

            combobox.addView(darkerlayout);
            combobox.addView(lighterlayout);
            ll.addView(combobox);
            LinearLayout gap = new LinearLayout(this);
            gap.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 20));
            ll.addView(gap);

            final int finalI = i;
            combobox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (more_home_title[finalI]=="FESTIVALS"){
                        Intent it = new Intent(MainActivity.this,FestivalActivity.class);
                        startActivity(it);
                    }
                    Toast.makeText(MainActivity.this, "hello" + more_home_title[finalI], Toast.LENGTH_LONG).show();
                }
            });
        }

        // for floating Button and also there is an xml in activity main
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
