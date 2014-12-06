package com.aduhack.whatareyoucravingforagain.model;

/**
 * Created by msancho on 12/07/14.
 */
public class OrderItem{
    public String menu_id;
    public String qty;

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
