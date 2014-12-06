package com.aduhack.whatareyoucravingforagain.helper;

/**
 * Created by jaggEd2 on 12/6/14.
 */
public class StaticUtility {

    //restaurant_table
    public static String Restaurant_id = "_id";
    public static String Restaurant_restaurant_name = "restaurant_name";
    public static String Restaurant_address= "address";
    public static String Restaurant_geolocation = "geolocation";
    public static String Restaurant_tags = "tags";
    public static String Restaurant_contact_number = "contact_number";
    public static String Restaurant_email = "email";
    public static String Restaurant_operating_hours = "operating_hours";
    public static String Restaurant_allowadvanceorder = "allowAdvanceOrder";
    public static String Restaurant_allowReservation = "allowReservation";
    public static String Restaurant_remarks = "remarks";

    //restaurant_image_table
    public static String Image_id = "_id";
    public static String Image_restaurant_id = "restaurant_id";
    public static String Image_image_path = "image_path";
    public static String Image_description = "description";

    //Menu
    public static String Menu_id = "_id";
    public static String Menu_restaurant_id = "restaurant_id";
    public static String Menu_food_name = "food_name";
    public static String Menu_price = "price";
    public static String Menu_description = "description";
    public static String Menu_tags = "tags";
    public static String Menu_remarks = "remarks";
    public static String Menu_isAvailable = "isAvailable";

    //Reservation
    public static String Reservation_id = "_id";
    public static String Reservation_restaurant_id = "restaurant_id";
    public static String Reservation_user_id = "user_id";
    public static String Reservation_reservation_datetime = "reservation_datetime";
    public static String Reservation_reservation_pax = "reservation_pax";
    public static String Reservation_status = "status";

    //Advance_Order
    public static String Advance_Order_id = "id";
    public static String Advance_Order_pickup_datetime = "pickup_datetime";
    public static String Advance_Order_user_id = "user_id";
    public static String Advance_Order_reservation_id = "reservation_id";
    public static String Advance_Order_amountDue = "amountDue";
    public static String Advance_Order_isTogo = "isTogo";
    public static String Advance_Order_status = "status";

    //Advance_Order_Item
    public static String Advance_Order_Item_id = "id";
    public static String Advance_Order_Item_advance_order_id = "advance_order_id";
    public static String Advance_Order_Item_menu_id = "menu_id";
    public static String Advance_Order_Item_qty = "qty";

    //webpost
    //user
    public static String user_first_name = "firstName";
    public static String user_last_name = "lastName";
    public static String user_contact_number = "contactNumber";
    public static String user_email = "email";

    //restaurant_id
    public static String web_restaurant_id = "restaurantId";

    //reservation
    public static String reservation_restaurant_id = "restaurantId";
    public static String reservation_user_id = "userId";
    public static String reservation_reservation_datetime = "reservationDatetime";
    public static String reservation_reservation_pax = "reservationPax";
    public static String reservation_status = "status";

    //rating
    public static String rating_restaurant_id = "restaurantId";
    public static String rating_name = "name";
    public static String rating_rate = "rate";
    public static String rating_comment = "comment";
    public static String rating_image_path = "imagePath";

    //order
    public static String order_pickup_datetime = "pickupDatetime";
    public static String order_user_id = "userId";
    public static String order_amountDue = "amountDue";
    public static String order_isTogo = "isToGo";
    public static String order_items = "items[]";
    public static String order_qty = "qty[]";

}
