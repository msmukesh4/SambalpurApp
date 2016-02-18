package com.sbp.sambalpurandroidapp;

/**
 * Created by mukesh on 17/1/16.
 */
public class Festival {

    int id;
    String festival_name;
    String festival_icon;
    String festval_banner;
    String festival_date;
    String festival_details;
    String[] festival_images;
    String festival_id;
    Double latitude;
    Double longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getFestival_images() {
        return festival_images;
    }

    public void setFestival_images(String[] festival_images) {
        this.festival_images = festival_images;
    }

    public String getFestival_id() {
        return festival_id;
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

    public void setFestival_id(String festival_id) {
        this.festival_id = festival_id;
    }

    public String getFestival_name() {
        return festival_name;
    }

    public void setFestival_name(String festival_name) {
        this.festival_name = festival_name;
    }

    public String getFestival_icon() {
        return festival_icon;
    }

    public void setFestival_icon(String festival_icon) {
        this.festival_icon = festival_icon;
    }

    public String getFestval_banner() {
        return festval_banner;
    }

    public void setFestval_banner(String festval_banner) {
        this.festval_banner = festval_banner;
    }

    public String getFestival_date() {
        return festival_date;
    }

    public void setFestival_date(String festival_date) {
        this.festival_date = festival_date;
    }

    public String getFestival_details() {
        return festival_details;
    }

    public void setFestival_details(String festival_details) {
        this.festival_details = festival_details;
    }

}
