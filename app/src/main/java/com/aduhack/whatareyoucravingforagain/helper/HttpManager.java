package com.aduhack.whatareyoucravingforagain.helper;

import android.support.annotation.NonNull;
import android.util.Log;

import com.aduhack.whatareyoucravingforagain.database.DataHelper;
import com.aduhack.whatareyoucravingforagain.model.Menu;
import com.aduhack.whatareyoucravingforagain.model.OrderItem;
import com.aduhack.whatareyoucravingforagain.model.OrderModel;
import com.aduhack.whatareyoucravingforagain.model.RatingModel;
import com.aduhack.whatareyoucravingforagain.model.ReservationModel;
import com.aduhack.whatareyoucravingforagain.model.Restaurant;
import com.aduhack.whatareyoucravingforagain.model.RestaurantImage;
import com.aduhack.whatareyoucravingforagain.model.UserModel;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jaggEd2 on 12/6/14.
 */
public class HttpManager {


    /*methods
    *  - getRestaurants
    *  -getmenu
    *  -getimages
    *
    *  post
    *  -send ratings
    *  -registeruser
    *  -setreservation
    *  -setorder
    * */
    private static String url = "";


    private static String Domain = "http://marqueepi.no-ip.biz/atnt/webapp/index.php";

    private static String url_get_restaurant = Domain +"/restaurant/getRestaurant";
    private static String url_get_image = Domain + "/images/getImages";
    private static String url_get_menu = Domain + "/menu/getMenu";
    private static String url_get_ratings = Domain + "/ratings/getRatings";

    private static String url_register_user = Domain + "/users/registerUsers";
    private static String url_get_reservation = Domain + "/reservation/getReservation";
    private static String url_set_order = Domain + "/advance_order/setOrder";

    private static String url_set_rating = Domain + "/ratings/setRatings";
    private static String url_set_reservation = Domain + "/reservation/setReservation";


    private HttpHelper _httpHelper;
    private DataHelper _database;

    public HttpManager(DataHelper _data){
        _httpHelper = new HttpHelper();
        _database = _data;
    }

    public String registerUser(UserModel user){
        List<NameValuePair> value = new ArrayList<NameValuePair>(4);
        String result = "";
        value.add(new BasicNameValuePair(StaticUtility.user_first_name, user.getFirst_name()));
        value.add(new BasicNameValuePair(StaticUtility.user_last_name, user.getLast_name()));
        value.add(new BasicNameValuePair(StaticUtility.user_contact_number, user.getContact_number()));
        value.add(new BasicNameValuePair(StaticUtility.user_email, user.getEmail()));
        try{
           result = EntityUtils.toString(_httpHelper.postResponse(url_register_user, value));


        }catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public void getRestaurants(){

        String result="";
        try{
            result = EntityUtils.toString(_httpHelper.getResponse(url_get_restaurant));


        }catch(IOException e){
            e.printStackTrace();
        }
        if(result != null){

            try {
                JSONObject jObject = new JSONObject(result);
                JSONArray restos = jObject.getJSONArray("restaurants");
                List<Restaurant> restoList = new ArrayList<Restaurant>();
                Restaurant resto;
                for (int i = 0; i < restos.length(); i++) {
                    JSONObject a = restos.getJSONObject(i);
                    resto = new Restaurant();
                    resto.setRestaurant_id(a.getInt("id"));
                    resto.setRestaurant_name(a.getString("restaurant_name"));
                    resto.setAddress(a.getString("address"));
                    resto.setGeolocation(a.getString("geo_location"));
                    resto.setTags(a.getString("tags"));
                    resto.setContact_number(a.getString("contact_number"));
                    resto.setEmail(a.getString("email"));
                    resto.setOperating_hours(a.getString("operationg_hours"));
                    resto.setAllowAdvanceOrder(a.getString("allow_advanced_order"));
                    resto.setAllowReservation(a.getString("allow_reservation"));
                    resto.setRemarks(a.getString("remarks"));

//                    "id":"1","restaurant_name":"test restaurant",
//                            "address":"Makati","geo_location":null,
//                            "tags":null,"contact_number":null,"email":null,
//                            "operationg_hours":null,"allow_advanced_order":null,
//                            "allow_reservation":null,"remarks":null,"is_logged":null}
                    restoList.add(resto);

                }
                _database.AddRestaurants(restoList);

            }catch(JSONException e){
                e.printStackTrace();
            }

        }

    }

    public void getMenu(){

        String result="";
        try{
            result = EntityUtils.toString(_httpHelper.getResponse(url_get_menu));


        }catch(IOException e){
            e.printStackTrace();
        }
        if(result != null){

            try {
                JSONObject jObject = new JSONObject(result);
                JSONArray menus = jObject.getJSONArray("menu");
                List<Menu> menuList = new ArrayList<Menu>();
                Menu menu;
                for (int i = 0; i < menus.length(); i++) {
                    JSONObject a = menus.getJSONObject(i);
                    menu = new Menu();
                    menu.setMenu_id(a.getInt("id"));
                    menu.setRestaurant_id(a.getString("restaurant_id"));
                    menu.setFood_name(a.getString("food_name"));
                    menu.setPrice(a.getString("price"));
                    menu.setTags(a.getString("tags"));
                    menu.setRemarks(a.getString("remarks"));
                    menu.setIsAvailable(a.getString("is_available"));
                    menu.setDescription(a.getString("description"));

//                    "id":"1","restaurant_id":"1","food_name":"Fried Kang Kong",
// "price":"1000","tags":"fried,Kang kong","remarks":"Yummy",
// "is_available":"1","description":"Test"
                    menuList.add(menu);

                }
                _database.AddMenu(menuList);

            }catch(JSONException e){
                e.printStackTrace();
            }

        }

    }

    public List<RatingModel> getRating(int restoId){

        String result="";
        List<NameValuePair> value = new ArrayList<NameValuePair>(1);
        value.add(new BasicNameValuePair(StaticUtility.web_restaurant_id, restoId+""));
        try{
            result = EntityUtils.toString(_httpHelper.postResponse(url_get_ratings, value));


        }catch(IOException e){
            e.printStackTrace();
        }
        if(result != null){

            try {
                JSONObject jObject = new JSONObject(result);
                JSONArray ratings = jObject.getJSONArray("ratings");
                List<RatingModel> ratingList = new ArrayList<RatingModel>();
                RatingModel rating;
                for (int i = 0; i < ratings.length(); i++) {
                    JSONObject a = ratings.getJSONObject(i);
                    rating = new RatingModel();
                    rating.setId(a.getInt("id"));
                    rating.setRestaurant_id(a.getString("restaurant_id"));
                    rating.setRate(a.getString("rate"));
                    rating.setComment(a.getString("comment"));
                    rating.setImage_path(a.getString("image_path"));

//           ratings[{"id":"1","restaurant_id":"1","rate":"5","comment":"WOW","image_path":"test\/test"}]
                    ratingList.add(rating);

                }
                return ratingList;

            }catch(JSONException e){
                e.printStackTrace();
            }

        }
        return null;
    }

    public void getRestaurantImage(){

        String result="";
        try{
            result = EntityUtils.toString(_httpHelper.getResponse(url_get_image));


        }catch(IOException e){
            e.printStackTrace();
        }
        if(result != null){

            try {
                JSONObject jObject = new JSONObject(result);
                JSONArray images = jObject.getJSONArray("images");
                List<RestaurantImage> imageList = new ArrayList<RestaurantImage>();
                RestaurantImage image;
                for (int i = 0; i < images.length(); i++) {
                    JSONObject a = images.getJSONObject(i);
                    image = new RestaurantImage();
                    image.setImage_id(a.getInt("id"));
                    image.setRestaurant_id(a.getString("restaurant_id"));
                    image.setImage_path(a.getString("food_name"));
                    image.setDescription(a.getString("price"));

//            images:[{"id":"1","restaurant_id":"1","image_path":"test\/test","description":"test"}]
                    imageList.add(image);

                }
                _database.AddImages(imageList);

            }catch(JSONException e){
                e.printStackTrace();
            }

        }

    }

    public void setReservation(ReservationModel reservation){
        List<NameValuePair> value = new ArrayList<NameValuePair>(4);

        value.add(new BasicNameValuePair(StaticUtility.reservation_restaurant_id, reservation.getRestaurant_id()));
        value.add(new BasicNameValuePair(StaticUtility.reservation_user_id, reservation.getUser_id()));
        value.add(new BasicNameValuePair(StaticUtility.reservation_reservation_datetime, reservation.getReservation_datetime()));
        value.add(new BasicNameValuePair(StaticUtility.reservation_reservation_pax, reservation.getReservation_pax()));
        try{
            String result = EntityUtils.toString(_httpHelper.postResponse(url_set_reservation,value));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setRating(RatingModel rating){
        List<NameValuePair> value = new ArrayList<NameValuePair>(4);

        value.add(new BasicNameValuePair(StaticUtility.rating_restaurant_id, rating.getRestaurant_id()));
        value.add(new BasicNameValuePair(StaticUtility.rating_name, rating.getName()));
        value.add(new BasicNameValuePair(StaticUtility.rating_rate, rating.getRate()));
        value.add(new BasicNameValuePair(StaticUtility.rating_comment, rating.getComment()));

        try{
            String result = EntityUtils.toString(_httpHelper.postResponse(url_set_rating,value));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setOrder(OrderModel order){
        List<OrderItem> orderItems = order.getOrderItems();

        int n = 5+(orderItems.size()*2);
        List<NameValuePair> value = new ArrayList<NameValuePair>(n);

        value.add(new BasicNameValuePair(StaticUtility.order_user_id, order.getUser_id()));
        value.add(new BasicNameValuePair(StaticUtility.order_pickup_datetime, order.getPickup_datetime()));
        value.add(new BasicNameValuePair(StaticUtility.order_amountDue, order.getAmountDue()));
        value.add(new BasicNameValuePair(StaticUtility.order_isTogo, order.getIsTogo()));
        value.add(new BasicNameValuePair(StaticUtility.order_restaurant_id, order.getReservation_id()));
        for(OrderItem item: orderItems){
            value.add(new BasicNameValuePair(StaticUtility.order_items, item.getMenu_id() ));
            value.add(new BasicNameValuePair(StaticUtility.order_qty, item.getQty()));


        }

        try{
            String result = EntityUtils.toString(_httpHelper.postResponse(url_set_order,value));
            Log.v("result", result);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
