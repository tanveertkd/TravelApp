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
public class PlacesFragment extends Fragment {


    public PlacesFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        ArrayList<pojo> pojoArrayList = new ArrayList<pojo>();
        pojoArrayList.add(new pojo(getString(R.string.place_one), R.drawable.place_one, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.place_one_location), R.drawable.ic_phone_solid, getString(R.string.place_one_phone)));
        pojoArrayList.add(new pojo(getString(R.string.place_two), R.drawable.place_two, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.place_two_location), R.drawable.ic_phone_solid, getString(R.string.place_two_phone)));
        pojoArrayList.add(new pojo(getString(R.string.place_three), R.drawable.place_three, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.place_three_location), R.drawable.ic_phone_solid, getString(R.string.place_three_phone)));
        pojoArrayList.add(new pojo(getString(R.string.place_four), R.drawable.place_four, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.place_four_location), R.drawable.ic_phone_solid, getString(R.string.place_four_phone)));
        pojoArrayList.add(new pojo(getString(R.string.place_five), R.drawable.place_five, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.place_five_location), R.drawable.ic_phone_solid, getString(R.string.place_five_phone)));

        HotelsAdapter adapter = new HotelsAdapter(getActivity(), pojoArrayList);
        ListView listViewItems = (ListView) rootView.findViewById(R.id.list);
        listViewItems.setAdapter(adapter);

        return rootView;
    }

}
