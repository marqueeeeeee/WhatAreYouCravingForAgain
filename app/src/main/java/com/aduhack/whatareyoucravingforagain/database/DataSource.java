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
			"_id integer not null," +
			"restaurant_name text not null," +
			"address text not null," +
			"geolocation text not null," +
			"tags text not null," +
			"contact_number text not null," +
            "email text not null," +
            "operating_hours text not null," +
            "allowAdvanceOrder text not null," +
            "allowReservation text not null," +
			"remarks text not null);";



    private static final String RESTAURANT_IMAGE_TABLE = "create table Restaurant_Image(" +
            "_id integer not null," +
            "restaurant_id text not null," +
            "image_path text not null," +
            "description text not null);";


    private static final String MENU_TABLE = "create table Menu(" +
            "_id integer primary key autoincrement," +
            "restaurant_id text not null," +
            "food_name text not null," +
            "price text not null," +
            "description text not null," +
            "tags text not null," +
            "remarks text not null," +
            "isAvailable text not null);";

    private static final String RESERVATION_TABLE = "create table Reservation(" +
            "_id integer primary key autoincrement," +
            "restaurant_id text not null," +
            "user_id text not null," +
            "reservation_datetime text not null," +
            "reservation_pax text not null," +
            "status text not null);";


    private static final String ADVANCE_ORDER_TABLE = "create table Advance_Order(" +
            "_id integer primary key autoincrement," +
            "pickup_datetime text not null," +
            "user_id text not null," +
            "reservation_id text not null," +
            "amountDue text not null," +
            "isTogo text not null," +
            "status text not null);";

    private static final String ADVANCE_ORDER_ITEM_TABLE = "create table Advance_Order_Item(" +
            "_id integer primary key autoincrement," +
            "advance_order_id text not null," +
            "menu_id text not null," +
            "qty text not null);";


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
