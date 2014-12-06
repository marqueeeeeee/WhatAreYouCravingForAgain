package com.aduhack.whatareyoucravingforagain.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.aduhack.whatareyoucravingforagain.R;
import com.aduhack.whatareyoucravingforagain.common.CustomListViewAdapter;
import com.aduhack.whatareyoucravingforagain.database.DataHelper;
import com.aduhack.whatareyoucravingforagain.model.ListViewAdapterModelWithAvatar;
import com.aduhack.whatareyoucravingforagain.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class MenuShopDetail extends Activity {

    int mode, id;
    Button ReserveButton, OrderAheadButton;
    ListView MenuList;
    ArrayList<ListViewAdapterModelWithAvatar> lvadp;

    TextView MainText, SubText, SubSubText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_shop_detail);


        MainText = (TextView) findViewById(R.id.tv_restaurantName);
        SubText = (TextView) findViewById(R.id.tv_address);
        SubSubText = (TextView) findViewById(R.id.tv_contact);
        ReserveButton = (Button) findViewById(R.id.ReservceButton);
        OrderAheadButton = (Button) findViewById(R.id.OrderAheadButton);

        DataHelper dh = new DataHelper(getApplicationContext());
        dh.open();
        mode = getIntent().getIntExtra("mode",0);
        Long resid = getIntent().getLongExtra("Id", 0);

        id = Integer.parseInt(resid.toString());



        lvadp = new ArrayList<ListViewAdapterModelWithAvatar>();


        MenuList = (ListView) findViewById(R.id.Detail_MenuListView);

        ReserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Reservation.class);

                i.putExtra("Id", id);
                startActivity(i);

            }
        });

        OrderAheadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        if(mode == 0) {
            setupButtons(0,0);
            com.aduhack.whatareyoucravingforagain.model.Menu menu = dh.GetMenu(id);

            MainText.setText(menu.food_name);
            SubText.setText(menu.description);
            SubSubText.setText(menu.price);
        }
        else {
            setupButtons(1, 1);
            Restaurant restaurant = dh.GetRestaurant(id);

            MainText.setText(restaurant.getRestaurant_name());
            SubText.setText(restaurant.getAddress());
            SubSubText.setText(restaurant.getContact_number());

            List<com.aduhack.whatareyoucravingforagain.model.Menu> menu = dh.GetMenusDetails(id);

            for (com.aduhack.whatareyoucravingforagain.model.Menu item : menu) {
                ListViewAdapterModelWithAvatar lv = new ListViewAdapterModelWithAvatar();
                lv.MainText = item.food_name;
                lv.SubText = item.description;
                lv.Id = item.Menu_id;
                lv.PriceText = item.price;

                lvadp.add(lv);
            }

            MenuList.setAdapter(new CustomListViewAdapter(getApplicationContext(), lvadp));

        }

    }


    private void setupButtons(int reserveStatus, int orderAheadStatus) {

        if(reserveStatus == 1) ReserveButton.setVisibility(View.VISIBLE);
        else ReserveButton.setVisibility(View.GONE);

        if(orderAheadStatus == 1) OrderAheadButton.setVisibility(View.VISIBLE);
        else OrderAheadButton.setVisibility(View.GONE);
    }


    private void DummyData() {
        for(int i=0; i<10; i++) {
            ListViewAdapterModelWithAvatar lv = new ListViewAdapterModelWithAvatar();
            lv.Id = 1;
            lv.MainText = "Chocolate Rolls";
            lv.SubText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";
            lvadp.add(lv);
        }

        MenuList.setAdapter(new CustomListViewAdapter(getApplicationContext(), lvadp));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shop_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
