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
 * Created by mukesh on 18/2/16.
 */
public class ShopActivity extends AppCompatActivity {

    ListView list_view_shop;
    ArrayList<Shop> shopList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        list_view_shop = (ListView) findViewById(R.id.list);
        shopList = new ArrayList<Shop>();

        Shop raw_festival = new Shop();
        raw_festival.setShop_name("Balaji Enterprise");
        raw_festival.setId(1);
        raw_festival.setRating(5);
        raw_festival.setShop_uid("f12");
        raw_festival.setDetails("asdasdasdfnojnvdsjanvjobrsiubvsnanjvkssajgvklgj jfkmvkhjf j ogkaajgrejigrjgnjioers");
        raw_festival.setShop_icon("http://www.8icon.com/public/png/iconshock-batman-Logo-128.png");
        raw_festival.setCaption("We sell everything");
        shopList.add(raw_festival);

        raw_festival = new Shop();
        raw_festival.setShop_uid("f13");
        raw_festival.setId(2);
        raw_festival.setRating(4);
        raw_festival.setShop_name("R.K. Sharma Store");
        raw_festival.setShop_icon("https://upload.wikimedia.org/wikipedia/commons/9/99/Opml-icon-128x128.png");
        raw_festival.setDetails("dnoncnvskjrnvjrsnjvnr fnnajnvjnrsjnv vkjnvkonvkjdn vnkjodhniuord");
        raw_festival.setCaption("We sell electronics");
        shopList.add(raw_festival);

        list_view_shop.setAdapter(new ShopListAdapter(this, shopList));

        System.out.println(list_view_shop.toString());

    }

    class ShopHolder {
        TextView s_name;
        TextView s_caption;
        ImageView s_icon;
        RatingBar s_rating;

        ShopHolder(View convertview){
            s_name = (TextView) convertview.findViewById(R.id.txt_shop_heading);
            s_caption = (TextView) convertview.findViewById(R.id.txt_shop_caption);
            s_icon = (ImageView) convertview.findViewById(R.id.img_shop_icon);
            s_rating = (RatingBar) convertview.findViewById(R.id.ratingBar);
        }
    }

    class ShopListAdapter extends BaseAdapter {

        Context context;
        ArrayList<Shop> shop_list;
        LayoutInflater inflater;

        public ShopListAdapter(ShopActivity shopActivity,ArrayList<Shop> shop_list ) {
            this.shop_list = shop_list;
            this.context = shopActivity;
            inflater = (LayoutInflater) shopActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return shop_list.size();
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
            ShopHolder fHolder;
            try{
                if (convertView == null){
                    convertView = inflater.inflate(R.layout.individual_shop_item,null,false);
                    fHolder = new ShopHolder(convertView);
                    convertView.setTag(fHolder);
                }else{
                    fHolder = (ShopHolder) convertView.getTag();
                }

                final Shop obj_festival = shop_list.get(position);
                fHolder.s_name.setText(obj_festival.getShop_name());
                fHolder.s_caption.setText(obj_festival.getCaption());
                String url = obj_festival.getShop_icon();
                fHolder.s_rating.setRating(obj_festival.getRating());
//                System.out.println("url["+position+"] is : "+url);
                Picasso.with(context).load(url).centerCrop().fit().into(fHolder.s_icon);
                final int sid = obj_festival.getId();
                System.out.println("sid : "+sid);

                convertView.setOnClickListener(new ListView.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"clicked on "+obj_festival.getId(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context,ShopDetailActivity.class);
                        int s = obj_festival.getId();
                        intent.putExtra("shop_id",""+s);
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
