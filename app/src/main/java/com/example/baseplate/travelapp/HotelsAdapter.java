package com.example.baseplate.travelapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HotelsAdapter extends ArrayAdapter<pojo>{
    public HotelsAdapter(@NonNull Context context, ArrayList<pojo> pojo) {
        super(context, 0, pojo);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.hotel_items, parent, false);
        }
        pojo currentItem = getItem(position);

        ImageView backgroundImage = (ImageView) listView.findViewById(R.id.category_image);
        backgroundImage.setImageResource(currentItem.getImageResource());

        TextView categoryHeader = (TextView) listView.findViewById(R.id.category_header);
        categoryHeader.setText(currentItem.getHeaderResource());

        View categoryGradient  = (View) listView.findViewById(R.id.grad);
        categoryGradient.setBackgroundResource(currentItem.getGradientResource());

        return listView;
    }
}
