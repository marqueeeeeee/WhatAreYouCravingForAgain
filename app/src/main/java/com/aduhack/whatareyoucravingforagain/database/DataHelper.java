package com.aduhack.whatareyoucravingforagain.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.aduhack.whatareyoucravingforagain.helper.StaticUtility;
import com.aduhack.whatareyoucravingforagain.model.Menu;
import com.aduhack.whatareyoucravingforagain.model.Restaurant;
import com.aduhack.whatareyoucravingforagain.model.RestaurantImage;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    private SQLiteDatabase db;
    private DataSource dataSource;

    public DataHelper(Context context) {
        dataSource = new DataSource(context);
    }

    public void open() throws SQLException {
        db = dataSource.getWritableDatabase();
    }

    public void close() {
        dataSource.close();
    }

    /*
	public void AddClasses(ClassModel cm){
		Cursor c = db.query("Class", null, "class_id = '"+cm.getClassId()+"'", null, null,
				null, null);
		int cCount = c.getCount();
		ContentValues cv = new ContentValues();
		if(cCount==0){
			cv.put(StaticUtility.dbClassId, cm.getClassId());
			cv.put(StaticUtility.dbName, cm.getName());
			cv.put(StaticUtility.dbProfessor, cm.getProfessor());
			cv.put(StaticUtility.dbDay, cm.getDay());
			cv.put(StaticUtility.dbFtime, cm.getFromtime());
			cv.put(StaticUtility.dbTTime, cm.getTotime());
			
			db.insert("Class", null, cv);
		}else{
			cv.put(StaticUtility.dbName, cm.getName());
			cv.put(StaticUtility.dbProfessor, cm.getProfessor());
			cv.put(StaticUtility.dbDay, cm.getDay());
			cv.put(StaticUtility.dbFtime, cm.getFromtime());
			cv.put(StaticUtility.dbTTime, cm.getTotime());
			
			db.update("Class", cv, "class_id = '"+cm.getClassId()+"'", null);
		}
		c.close();
	}

	public List<String> GetClasses(){
		Cursor c = db.query("Class", null, null, null, null, null, null, null);
		List<String> list = new ArrayList<String>();
		list.add("Choose Class");
		for(int i = 0; i<c.getCount();i++){
			c.moveToNext();
			list.add(c.getString(2));
		}
		c.close();
		return list;
		
	}*/

//    String selectQuery = "SELECT lastchapter FROM Bookdetails WHERE bookpath=?";
//    Cursor c = db.rawQuery(selectQuery, new String[] { fileName });
//    if (c.moveToFirst()) {
//        temp_address = c.getString(c.getColumnIndex("lastchapter"));
//    }
//    c.close();


    //get methods
    public List<Restaurant> GetRestaurants(String tag){

        String suery = "SELECT * FROM Restaurants WHERE tags LIKE %?%";
//        Cursor c = db.query("Restaurants", null, null, null, null, null, null, null);
        Cursor c = db.rawQuery(suery, new String[]{tag});
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        Restaurant res;
//        _id integer not null," +
//        restaurant_name text not null," +
//        address text not null," +
//        geolocation text not null," +
//        tags text not null," +
//        contact_number text not null," +
//        email text not null," +
//        operating_hours text not null," +
//        allowAdvanceOrder text not null," +
//        allowReservation text not null," +
//        remarks text not null);";
        for(int i = 0; i<c.getCount();i++){
            c.moveToNext();
            res = new Restaurant();
            res.setRestaurant_id(c.getInt(0));
            res.setRestaurant_name(c.getString(1));
            res.setAddress(c.getString(2));
            res.setGeolocation(c.getString(3));
            res.setTags(c.getString(4));
            res.setContact_number(c.getString(5));
            res.setEmail(c.getString(6));
            res.setOperating_hours(c.getString(7));
            res.setAllowAdvanceOrder(c.getString(8));
            res.setAllowReservation(c.getString(9));
            res.setRemarks(c.getString(10));

            restaurants.add(res);
        }
        c.close();
        return restaurants;

    }

    public List<RestaurantImage> GetRestaurantImages(int restaurant_id){
        String suery = "SELECT * FROM Restaurant_Image where restaurant_id="+restaurant_id;
        Cursor c = db.rawQuery(suery,null);
        List<RestaurantImage> restaurants = new ArrayList<RestaurantImage>();
        RestaurantImage res;
//          "_id integer not null," +
//        "restaurant_id text not null," +
//                "image_path text not null," +
//                "description text not null);";
        for(int i = 0; i<c.getCount();i++){
            c.moveToNext();
            res = new RestaurantImage();
            res.setImage_id(c.getInt(0));
            res.setRestaurant_id(c.getString(1));
            res.setImage_path(c.getString(2));
            res.setDescription(c.getString(3));

            restaurants.add(res);
        }
        c.close();
        return restaurants;

    }

    public Restaurant GetRestaurant(int restaurant_id){
        String suery = "SELECT * FROM Restaurants WHERE restaurant_id="+restaurant_id;
//        Cursor c = db.query("Restaurants", null, null, null, null, null, null, null);
        Cursor c = db.rawQuery(suery, null);
        Restaurant res;
//        _id integer not null," +
//        restaurant_name text not null," +
//        address text not null," +
//        geolocation text not null," +
//        tags text not null," +
//        contact_number text not null," +
//        email text not null," +
//        operating_hours text not null," +
//        allowAdvanceOrder text not null," +
//        allowReservation text not null," +
//        remarks text not null);";
        c.moveToNext();
        res = new Restaurant();
        res.setRestaurant_id(c.getInt(0));
        res.setRestaurant_name(c.getString(1));
        res.setAddress(c.getString(2));
        res.setGeolocation(c.getString(3));
        res.setTags(c.getString(4));
        res.setContact_number(c.getString(5));
        res.setEmail(c.getString(6));
        res.setOperating_hours(c.getString(7));
        res.setAllowAdvanceOrder(c.getString(8));
        res.setAllowReservation(c.getString(9));
        res.setRemarks(c.getString(10));

        c.close();
        return res;
    }

    public List<Menu> GetMenu(int restaurant_id){
        String suery = "SELECT * FROM Menu WHERE restaurant_id="+restaurant_id;
//        Cursor c = db.query("Restaurants", null, null, null, null, null, null, null);
        Cursor c = db.rawQuery(suery, null);
        List<Menu> menu = new ArrayList<Menu>();
        Menu _menu;

// "_id integer primary key autoincrement," +
//                "restaurant_id text not null," +
//                "food_name text not null," +
//                "price text not null," +
//                "description text not null," +
//                "tags text not null," +
//                "remarks text not null," +
//                "isAvailable text not null);";

        for(int i = 0; i<c.getCount();i++){
            c.moveToNext();
            _menu = new Menu();
            _menu.setMenu_id(c.getInt(0));
            _menu.setRestaurant_id(c.getString(1));
            _menu.setFood_name(c.getString(2));
            _menu.setPrice(c.getString(3));
            _menu.setDescription(c.getString(4));
            _menu.setTags(c.getString(5));
            _menu.setRemarks(c.getString(6));
            _menu.setIsAvailable(c.getString(7));

            menu.add(_menu);
        }
        c.close();
        return menu;
    }

    //add methods
    public void AddRestaurants(List<Restaurant> restaurants){
        ContentValues cv;
        for(Restaurant res: restaurants){
            cv = new ContentValues();

            cv.put(StaticUtility.Restaurant_id, res.getRestaurant_id());
            cv.put(StaticUtility.Restaurant_restaurant_name, res.getRestaurant_name());
            cv.put(StaticUtility.Restaurant_address, res.getAddress());
            cv.put(StaticUtility.Restaurant_geolocation, res.getGeolocation());
            cv.put(StaticUtility.Restaurant_tags, res.getTags());
            cv.put(StaticUtility.Restaurant_contact_number, res.getContact_number());
            cv.put(StaticUtility.Restaurant_email, res.getEmail());
            cv.put(StaticUtility.Restaurant_operating_hours, res.getOperating_hours());
            cv.put(StaticUtility.Restaurant_allowadvanceorder, res.getAllowAdvanceOrder());
            cv.put(StaticUtility.Restaurant_allowReservation, res.getAllowReservation());
            cv.put(StaticUtility.Restaurant_remarks, res.getRemarks());

            db.insert("Restaurant",null,cv);

        }

    }

    public void AddMenu(List<Menu> menus){
        ContentValues cv;
        for(Menu _menu: menus){
            cv = new ContentValues();
            cv.put(StaticUtility.Menu_id, _menu.getMenu_id());
            cv.put(StaticUtility.Menu_restaurant_id, _menu.getRestaurant_id());
            cv.put(StaticUtility.Menu_food_name, _menu.getFood_name());
            cv.put(StaticUtility.Menu_price, _menu.getPrice());
            cv.put(StaticUtility.Menu_description, _menu.getTags());
            cv.put(StaticUtility.Menu_tags, _menu.getTags());
            cv.put(StaticUtility.Menu_remarks, _menu.getRemarks());
            cv.put(StaticUtility.Menu_isAvailable, _menu.getIsAvailable());

            db.insert("Menu",null,cv);

        }

    }

    public void AddImages(List<RestaurantImage> images){
        ContentValues cv;
        for(RestaurantImage _image: images){
            cv = new ContentValues();
            cv.put(StaticUtility.Image_id, _image.getImage_id());
            cv.put(StaticUtility.Image_restaurant_id, _image.getRestaurant_id());
            cv.put(StaticUtility.Image_image_path, _image.getImage_path());
            cv.put(StaticUtility.Image_description, _image.getDescription());

            db.insert("Restaurant_Image",null,cv);

        }

    }
}
