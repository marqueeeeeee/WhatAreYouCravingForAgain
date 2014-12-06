package com.aduhack.whatareyoucravingforagain.model;

/**
 * Created by jaggEd2 on 12/6/14.
 */
public class ReservationModel {
//    "_id integer primary key autoincrement," +
//            "restaurant_id text not null," +
//            "user_id text not null," +
//            "reservation_datetime text not null," +
//            "reservation_pax text not null," +
//            "status text not null);";

    public int id;
    public String restaurant_id;
    public String user_id;
    public String reservation_datetime;
    public String reservation_pax;
    public String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReservation_datetime() {
        return reservation_datetime;
    }

    public void setReservation_datetime(String reservation_datetime) {
        this.reservation_datetime = reservation_datetime;
    }

    public String getReservation_pax() {
        return reservation_pax;
    }

    public void setReservation_pax(String reservation_pax) {
        this.reservation_pax = reservation_pax;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
