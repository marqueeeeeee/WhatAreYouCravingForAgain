package com.aduhack.whatareyoucravingforagain.model;

/**
 * Created by jaggEd2 on 12/6/14.
 */
public class Menu {

    public int Menu_id;
    public String restaurant_id;
    public String food_name;
    public String price;
    public String description;
    public String tags;
    public String remarks;
    public String isAvailable;

    public int getMenu_id() {
        return Menu_id;
    }

    public void setMenu_id(int menu_id) {
        Menu_id = menu_id;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }
}
