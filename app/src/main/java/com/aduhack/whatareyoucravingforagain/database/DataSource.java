package com.aduhack.whatareyoucravingforagain.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataSource extends SQLiteOpenHelper{
    private static final String DatabaseName = "Craving.db";
    private static final int DatabaseVersion = 1;
    private static String className = "DataSource";


    private static final String RESTAURANT_TABLE = "create table Restaurant(" +
            "_id integer," +
            "restaurant_name text," +
            "address text," +
            "geolocation text," +
            "tags text," +
            "contact_number text," +
            "email text," +
            "operating_hours text," +
            "allowAdvanceOrder text," +
            "allowReservation text," +
            "remarks text);";



    private static final String RESTAURANT_IMAGE_TABLE = "create table Restaurant_Image(" +
            "_id integer null," +
            "restaurant_id text null," +
            "image_path text null," +
            "description text null);";


    private static final String MENU_TABLE = "create table Menu(" +
            "_id integer primary key autoincrement," +
            "restaurant_id text null," +
            "food_name text null," +
            "price text null," +
            "description text null," +
            "tags text null," +
            "remarks text null," +
            "isAvailable text null);";

    private static final String RESERVATION_TABLE = "create table Reservation(" +
            "_id integer primary key autoincrement," +
            "restaurant_id text null," +
            "user_id text null," +
            "reservation_datetime text null," +
            "reservation_pax text null," +
            "status text null);";


    private static final String ADVANCE_ORDER_TABLE = "create table Advance_Order(" +
            "_id integer primary key autoincrement," +
            "pickup_datetime text null," +
            "user_id text null," +
            "reservation_id text null," +
            "amountDue text null," +
            "isTogo text null," +
            "status text null);";

    private static final String ADVANCE_ORDER_ITEM_TABLE = "create table Advance_Order_Item(" +
            "_id integer primary key autoincrement," +
            "advance_order_id text null," +
            "menu_id text null," +
            "qty text null);";


    public DataSource(Context context){
        super(context, DatabaseName, null, DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(RESTAURANT_TABLE);
        db.execSQL(RESTAURANT_IMAGE_TABLE);
        db.execSQL(MENU_TABLE);
        db.execSQL(RESERVATION_TABLE);
        db.execSQL(ADVANCE_ORDER_TABLE);
        db.execSQL(ADVANCE_ORDER_ITEM_TABLE);
        Log.v(className, "Database Created");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        db.execSQL("DROP TABLE IF EXISTS Restaurant");
        db.execSQL("DROP TABLE IF EXISTS Restaurant_Image");
        db.execSQL("DROP TABLE IF EXISTS Menu");
        db.execSQL("DROP TABLE IF EXISTS Reservation");
        db.execSQL("DROP TABLE IF EXISTS Advance_Order");
        db.execSQL("DROP TABLE IF EXISTS Advance_Order_Item");
        onCreate(db);
    }
}
