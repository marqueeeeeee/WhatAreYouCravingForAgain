package com.aduhack.whatareyoucravingforagain.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aduhack.whatareyoucravingforagain.R;

/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class ShopDetailFragment extends Fragment {


    public ShopDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_detail, container, false);
    }


}
