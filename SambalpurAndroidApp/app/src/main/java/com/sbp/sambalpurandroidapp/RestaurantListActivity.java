package com.sbp.sambalpurandroidapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mukesh on 21/2/16.
 */
public class RestaurantListActivity extends AppCompatActivity {

    ArrayList<Restaurant> restaurants_list;
    ListView list_View_restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        list_View_restaurants = (ListView) findViewById(R.id.list);
        restaurants_list = new ArrayList<Restaurant>();

        Restaurant restaurant = new Restaurant();
        restaurant.setId(1);
        restaurant.setRes_name("Kedia");
        restaurant.setCaption("family Restaurant");
        restaurant.setRating(5);
        restaurant.setRes_icon("http://www.8icon.com/public/png/iconshock-batman-Logo-128.png");
        restaurants_list.add(restaurant);

        restaurant = new Restaurant();
        restaurant.setId(2);
        restaurant.setRes_name("Sheela Tower");
        restaurant.setCaption("complete family Restaurant");
        restaurant.setRating(4);
        restaurant.setRes_icon("https://upload.wikimedia.org/wikipedia/commons/9/99/Opml-icon-128x128.png");
        restaurants_list.add(restaurant);

        list_View_restaurants.setAdapter(new RestaurantListAdapter(this, restaurants_list));

    }

    class RestaurantHolder {
        TextView r_name;
        TextView r_caption;
        ImageView r_icon;
        RatingBar r_rating;

        RestaurantHolder(View convertview){
            r_name = (TextView) convertview.findViewById(R.id.txt_res_heading);
            r_caption = (TextView) convertview.findViewById(R.id.txt_res_caption);
            r_icon = (ImageView) convertview.findViewById(R.id.img_res_icon);
            r_rating = (RatingBar) convertview.findViewById(R.id.res_ratingBar);
        }
    }

    class RestaurantListAdapter extends BaseAdapter {

        Context context;
        ArrayList<Restaurant> restaurnat_list;
        LayoutInflater inflater;

        public RestaurantListAdapter(RestaurantListActivity restaurantActivity,ArrayList<Restaurant> restaurnat_list ) {
            this.restaurnat_list = restaurnat_list;
            this.context = restaurantActivity;
            inflater = (LayoutInflater) restaurantActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return restaurnat_list.size();
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
            RestaurantHolder fHolder;
            try{
                if (convertView == null){
                    convertView = inflater.inflate(R.layout.individual_restaurant_item,null,false);
                    fHolder = new RestaurantHolder(convertView);
                    convertView.setTag(fHolder);
                }else{
                    fHolder = (RestaurantHolder) convertView.getTag();
                }

                final Restaurant obj_festival = restaurnat_list.get(position);
                fHolder.r_name.setText(obj_festival.getRes_name());
                fHolder.r_caption.setText(obj_festival.getCaption());
                String url = obj_festival.getRes_icon();
                fHolder.r_rating.setRating(obj_festival.getRating());
//                System.out.println("url["+position+"] is : "+url);
                Picasso.with(context).load(url).centerCrop().fit().into(fHolder.r_icon);
                final int sid = obj_festival.getId();
                System.out.println("sid : "+sid);

                convertView.setOnClickListener(new ListView.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "clicked on " + obj_festival.getId(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context,RestaurantDetailActivity.class);
                        int s = obj_festival.getId();
                        intent.putExtra("res_id",""+s);
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
