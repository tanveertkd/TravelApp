package com.example.baseplate.travelapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurentsFragments extends Fragment {


    public RestaurentsFragments() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        ArrayList<pojo> pojoArrayList = new ArrayList<pojo>();
        pojoArrayList.add(new pojo(getString(R.string.restaurant_one), R.drawable.restaurant_one, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.restaurant_one_location), R.drawable.ic_phone_solid, getString(R.string.restaurant_one_phone)));
        pojoArrayList.add(new pojo(getString(R.string.restaurant_two), R.drawable.restaurant_two, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.restaurant_two_location), R.drawable.ic_phone_solid, getString(R.string.restaurant_two_phone)));
        pojoArrayList.add(new pojo(getString(R.string.restaurant_three), R.drawable.restaurant_three, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.restaurant_three_location), R.drawable.ic_phone_solid, getString(R.string.restaurant_three_phone)));
        pojoArrayList.add(new pojo(getString(R.string.restaurant_four), R.drawable.restaurant_four, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.restaurant_four_location), R.drawable.ic_phone_solid, getString(R.string.restaurant_four_phone)));
        pojoArrayList.add(new pojo(getString(R.string.restaurant_five), R.drawable.restaurant_five, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.restaurant_five_location), R.drawable.ic_phone_solid, getString(R.string.restaurant_five_phone)));

        HotelsAdapter adapter = new HotelsAdapter(getActivity(), pojoArrayList);
        ListView listViewItems = (ListView) rootView.findViewById(R.id.list);
        listViewItems.setAdapter(adapter);

        return rootView;
    }

}
