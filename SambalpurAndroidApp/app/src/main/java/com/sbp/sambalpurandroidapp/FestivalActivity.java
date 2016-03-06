package com.sbp.sambalpurandroidapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mukesh on 3/1/16.
 */
public class FestivalActivity extends AppCompatActivity {

    // toobar items
    ImageView alert_bell_icon;
    boolean isNotificationAvailable = false;
    String strNotification_count = "";

    ListView list_view_festival;
    ArrayList<Festival> festivalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        list_view_festival = (ListView) findViewById(R.id.list);
        festivalList = new ArrayList<Festival>();

        // the festival array with json data
        // for demo we are just putting in raw data

        Festival raw_festival = new Festival();
        raw_festival.setFestival_date("21/12/2016");
        raw_festival.setFestival_id("f12");
        raw_festival.setFestival_details("asdasdasdfnojnvdsjanvjobrsiubvsnanjvkssajgvklgj jfkmvkhjf j ogkaajgrejigrjgnjioers");
        raw_festival.setFestival_icon("http://www.8icon.com/public/png/iconshock-batman-Logo-128.png");
        raw_festival.setFestival_name("Sital Sasthi");
        festivalList.add(raw_festival);

        raw_festival = new Festival();
        raw_festival.setFestival_id("f13");
        raw_festival.setFestival_date("22/12/2016");
        raw_festival.setFestival_name("Bhai Jutia");
        raw_festival.setFestival_icon("https://upload.wikimedia.org/wikipedia/commons/9/99/Opml-icon-128x128.png");
        raw_festival.setFestival_details("dnoncnvskjrnvjrsnjvnr fnnajnvjnrsjnv vkjnvkonvkjdn vnkjodhniuord");
        festivalList.add(raw_festival);

        list_view_festival.setAdapter(new FestivalListAdapter(this,festivalList));

    }

    class FestivalHolder {
        TextView f_name;
        TextView f_date;
        ImageView f_icon;

        FestivalHolder(View convertview){
            f_name = (TextView) convertview.findViewById(R.id.txt_festival_heading);
            f_date = (TextView) convertview.findViewById(R.id.txt_festival_caption);
            f_icon = (ImageView) convertview.findViewById(R.id.img_festival_icon);
        }
    }

    class FestivalListAdapter extends BaseAdapter{

        Context context;
        ArrayList<Festival> festival_list;
        LayoutInflater  inflater;

        public FestivalListAdapter(FestivalActivity festivalActivity,ArrayList<Festival> festival_list ) {
            this.festival_list = festival_list;
            this.context = festivalActivity;
            inflater = (LayoutInflater) festivalActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return festival_list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position,View convertView, ViewGroup parent) {
            FestivalHolder fHolder;
            try{
                if (convertView == null){
                    convertView = inflater.inflate(R.layout.individual_festival_item,null,false);
                    fHolder = new FestivalHolder(convertView);
                    convertView.setTag(fHolder);
                }else{
                    fHolder = (FestivalHolder) convertView.getTag();
                }

                Festival obj_festival = festival_list.get(position);
                fHolder.f_name.setText(obj_festival.getFestival_name());
                fHolder.f_date.setText(obj_festival.getFestival_date());
                String url = obj_festival.getFestival_icon();
//                System.out.println("url["+position+"] is : "+url);
                Picasso.with(context).load(url).centerCrop().fit().into(fHolder.f_icon);
//                fHolder.f_icon.setImageResource(R.drawable.logo);
                final String fid = obj_festival.getFestival_id();
                convertView.setOnClickListener(new ListView.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(context,"clicked on "+obj_festival.getFestival_name()+obj_festival.getFestival_id(),Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context,FestivalDetailActivity.class);
                        intent.putExtra("festival_id",fid);
                        context.startActivity(intent);
                    }
                });
            }catch (Exception ee){
                ee.printStackTrace();
            }
            return convertView;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

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

}
