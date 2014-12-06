package com.aduhack.whatareyoucravingforagain.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aduhack.whatareyoucravingforagain.R;
import com.aduhack.whatareyoucravingforagain.common.CustomListViewAdapter;
import com.aduhack.whatareyoucravingforagain.model.ListViewAdapterModelWithAvatar;

import java.util.ArrayList;

/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class MenuShopFragment extends Fragment {

    ListView MenuShopListView;
    ArrayList<ListViewAdapterModelWithAvatar> lvadp;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_menu_shop, container, false);

        lvadp = new ArrayList<ListViewAdapterModelWithAvatar>();
        MenuShopListView = (ListView) view.findViewById(R.id.menu_shop_listview);
        DummyData();

        return view;
    }

    private void DummyData() {


        for(int i=0; i<10; i++) {
            ListViewAdapterModelWithAvatar lv = new ListViewAdapterModelWithAvatar();
            lv.Id = 1;
            lv.MainText = "Chocolate Rolls";
            lv.SubText = "chocolate";
            lvadp.add(lv);
        }


        MenuShopListView.setAdapter(new CustomListViewAdapter(getActivity().getApplicationContext(), lvadp));

    }


}
