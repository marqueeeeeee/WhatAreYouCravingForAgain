package com.aduhack.whatareyoucravingforagain.model;

/**
 * Created by jaggEd2 on 12/6/14.
 */
public class RestaurantImage {
//    "_id integer not null," +
//    "restaurant_id text not null," +
//    "image_path text not null," +
//    "description text not null);";

    private int image_id;
    private String restaurant_id;
    private String image_path;
    private String description;

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
