package com.aduhack.whatareyoucravingforagain.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.aduhack.whatareyoucravingforagain.R;
import com.aduhack.whatareyoucravingforagain.common.CustomListViewAdapter;
import com.aduhack.whatareyoucravingforagain.model.ListViewAdapterModelWithAvatar;

import java.util.ArrayList;
import java.util.List;

public class MenuShopDetail extends Activity {

    int mode, id;
    Button ReserveButton, OrderAheadButton;
    ListView MenuList;
    ArrayList<ListViewAdapterModelWithAvatar> lvadp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_shop_detail);

        mode = getIntent().getIntExtra("mode",0);
        id = getIntent().getIntExtra("Id", 0);

        lvadp = new ArrayList<ListViewAdapterModelWithAvatar>();

        ReserveButton = (Button) findViewById(R.id.ReservceButton);
        OrderAheadButton = (Button) findViewById(R.id.OrderAheadButton);
        MenuList = (ListView) findViewById(R.id.Detail_MenuListView);

        ReserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        OrderAheadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        DummyData();

    }


    private void setupButtons(int reserveStatus, int orderAheadStatus) {

        if(reserveStatus == 1) ReserveButton.setVisibility(View.VISIBLE);
        else ReserveButton.setVisibility(View.GONE);

        if(orderAheadStatus == 1) ReserveButton.setVisibility(View.VISIBLE);
        else ReserveButton.setVisibility(View.GONE);
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
