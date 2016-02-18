package com.sbp.sambalpurandroidapp;

/**
 * Created by mukesh on 18/2/16.
 */
public class EmergencyService {

    int id;
    String service_type;
    String name;
    String contact_number1;
    String contact_number2;
    String icon;
    String area;
    Double latitude;
    Double longitude;
    String address;

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_number1() {
        return contact_number1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
