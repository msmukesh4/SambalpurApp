package com.sbp.sambalpurandroidapp;

/**
 * Created by mukesh on 18/2/16.
 */
public class Shop {

    int id;
    String shop_name;
    String shop_uid;
    String shop_type;  // (Men/women/kids)
    String shop_banner;
    String shop_icon;
    String owner_name;
    String address;
    Double latitude;
    Double longitude;
    int rating;
    String contact_number1;
    String contact_number2;
    String caption;
    String details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_uid() {
        return shop_uid;
    }

    public void setShop_uid(String shop_uid) {
        this.shop_uid = shop_uid;
    }

    public String getShop_type() {
        return shop_type;
    }

    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    public String getShop_banner() {
        return shop_banner;
    }

    public void setShop_banner(String shop_banner) {
        this.shop_banner = shop_banner;
    }

    public String getShop_icon() {
        return shop_icon;
    }

    public void setShop_icon(String shop_icon) {
        this.shop_icon = shop_icon;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContact_number1() {
        return contact_number1;
    }

    public void setContact_number1(String contact_number1) {
        this.contact_number1 = contact_number1;
    }

    public String getContact_number2() {
        return contact_number2;
    }

    public void setContact_number2(String contact_number2) {
        this.contact_number2 = contact_number2;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
