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
public class TrainFragment extends Fragment {


    public TrainFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        ArrayList<pojo> pojoArrayList = new ArrayList<pojo>();
        pojoArrayList.add(new pojo(getString(R.string.ams_central), R.drawable.train_one, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.train_one_location), R.drawable.ic_phone_solid, getString(R.string.train_one_phone)));
        pojoArrayList.add(new pojo(getString(R.string.ams_amstel), R.drawable.train_two, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.train_two_location), R.drawable.ic_phone_solid, getString(R.string.train_two_phone)));
        pojoArrayList.add(new pojo(getString(R.string.ams_bijlmer), R.drawable.train_three, R.drawable.gradient_splash, R.drawable.ic_map_, getString(R.string.train_two_location), R.drawable.ic_phone_solid, getString(R.string.train_two_phone)));

        HotelsAdapter adapter = new HotelsAdapter(getActivity(), pojoArrayList);
        ListView listViewItems = (ListView) rootView.findViewById(R.id.list);
        listViewItems.setAdapter(adapter);

        return rootView;
    }

}
