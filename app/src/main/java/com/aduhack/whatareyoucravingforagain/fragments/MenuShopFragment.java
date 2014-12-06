package com.aduhack.whatareyoucravingforagain.fragments;


import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.aduhack.whatareyoucravingforagain.R;
import com.aduhack.whatareyoucravingforagain.activity.MenuShopActivity;
import com.aduhack.whatareyoucravingforagain.activity.MenuShopDetail;
import com.aduhack.whatareyoucravingforagain.common.CustomListViewAdapter;
import com.aduhack.whatareyoucravingforagain.model.ListViewAdapterModelWithAvatar;

import java.util.ArrayList;

/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class MenuShopFragment extends Fragment {

    GridView MenuShopListView;
    ArrayList<ListViewAdapterModelWithAvatar> lvadp;

    int mode = 0; // 0 = menu detail and 1 = shop detail


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_menu_shop, container, false);

        lvadp = new ArrayList<ListViewAdapterModelWithAvatar>();
        MenuShopListView = (GridView) view.findViewById(R.id.menu_shop_listview);

        MenuShopListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getActivity(), MenuShopDetail.class);
                i.putExtra("mode", mode);
                i.putExtra("Id", parent.getId());
                startActivity(i);
            }
        });

        DummyData();

        return view;

    }

    private void DummyData() {


        for(int i=0; i<10; i++) {
            ListViewAdapterModelWithAvatar lv = new ListViewAdapterModelWithAvatar();
            lv.Id = 1;
            lv.MainText = "Chocolate Rolls";
            lv.SubText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";
            lvadp.add(lv);
        }

        MenuShopListView.setAdapter(new CustomListViewAdapter(getActivity().getApplicationContext(), lvadp));

    }


}
