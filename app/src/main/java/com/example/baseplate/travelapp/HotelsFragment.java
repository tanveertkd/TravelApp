package com.example.baseplate.travelapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {


    public HotelsFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.item_list, container, false);

        final ArrayList<pojo> pojoArrayList = new ArrayList<pojo>();
        pojoArrayList.add(new pojo(getString(R.string.hotel_one), R.drawable.hotel_one, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.hotel_one_location), R.drawable.ic_phone_solid, getString(R.string.hotel_one_phone)));
        pojoArrayList.add(new pojo(getString(R.string.hotel_two), R.drawable.hotel_tow, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.hotel_two_location), R.drawable.ic_phone_solid,getString(R.string.hotel_two_phone)));
        pojoArrayList.add(new pojo(getString(R.string.hotel_three), R.drawable.hotel_three, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.hotel_three_location), R.drawable.ic_phone_solid,getString(R.string.hotel_three_phone)));
        pojoArrayList.add(new pojo(getString(R.string.hotel_four), R.drawable.hotel_four, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.hotel_four_location), R.drawable.ic_phone_solid,getString(R.string.hotel_four_phone)));
        pojoArrayList.add(new pojo(getString(R.string.hotel_five), R.drawable.hotel_five, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.hotel_five_location), R.drawable.ic_phone_solid,getString(R.string.hotel_five_phone)));

        HotelsAdapter adapter = new HotelsAdapter(getActivity(), pojoArrayList);
        ListView listViewItems = (ListView) rootView.findViewById(R.id.list);
        listViewItems.setAdapter(adapter);

        return rootView;
    }

}
