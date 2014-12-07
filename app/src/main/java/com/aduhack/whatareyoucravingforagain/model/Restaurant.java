package com.aduhack.whatareyoucravingforagain.model;

/**
 * Created by jaggEd2 on 12/6/14.
 */
public class Restaurant {

    private int Restaurant_id;
    private String restaurant_name;
    private String geolocation;
    private String address;
    private String tags;
    private String contact_number;
    private String email;
    private String operating_hours;
    private String allowAdvanceOrder;
    private String allowReservation;
    private String remarks;
    private String metersAway;

    public String getMetersAway() {
        return metersAway;
    }

    public void setMetersAway(String metersAway) {
        this.metersAway = metersAway;
    }

    public int getRestaurant_id() {
        return Restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        Restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOperating_hours() {
        return operating_hours;
    }

    public void setOperating_hours(String operating_hours) {
        this.operating_hours = operating_hours;
    }

    public String getAllowAdvanceOrder() {
        return allowAdvanceOrder;
    }

    public void setAllowAdvanceOrder(String allowAdvanceOrder) {
        this.allowAdvanceOrder = allowAdvanceOrder;
    }

    public String getAllowReservation() {
        return allowReservation;
    }

    public void setAllowReservation(String allowReservation) {
        this.allowReservation = allowReservation;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



}
