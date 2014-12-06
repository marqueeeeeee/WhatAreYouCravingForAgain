package com.aduhack.whatareyoucravingforagain.model;

import java.util.List;

/**
 * Created by jaggEd2 on 12/6/14.
 */
public class OrderModel {

//    "_id integer primary key autoincrement," +
//            "pickup_datetime text not null," +
//            "user_id text not null," +
//            "reservation_id text not null," +
//            "amountDue text not null," +
//            "isTogo text not null," +
//            "status text not null);";
//
//            "_id integer primary key autoincrement," +
//            "advance_order_id text not null," +
//            "menu_id text not null," +
//            "qty text not null);";

    private String pickup_datetime;
    private String user_id;
    private String reservation_id;
    private String amountDue;
    private String isTogo;

    private List<OrderItem> OrderItems;

    public String getPickup_datetime() {
        return pickup_datetime;
    }

    public void setPickup_datetime(String pickup_datetime) {
        this.pickup_datetime = pickup_datetime;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(String reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(String amountDue) {
        this.amountDue = amountDue;
    }

    public String getIsTogo() {
        return isTogo;
    }

    public void setIsTogo(String isTogo) {
        this.isTogo = isTogo;
    }

    public List<OrderItem> getOrderItems() {
        return OrderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        OrderItems = orderItems;
    }
}
