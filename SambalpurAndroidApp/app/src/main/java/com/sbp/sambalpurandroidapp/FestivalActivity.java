package com.sbp.sambalpurandroidapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukesh on 3/1/16.
 */
public class FestivalActivity extends AppCompatActivity {

    ListView list_view_festival;
    ArrayList<Festival> festivalList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival);
        list_view_festival = (ListView) findViewById(R.id.festival_list);
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
                System.out.println("url["+position+"] is : "+url);
                Picasso.with(context).load(url).into(fHolder.f_icon);
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
}
