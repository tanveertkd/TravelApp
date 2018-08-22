package com.example.baseplate.travelapp;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsAdapter extends ArrayAdapter<pojo> {
    public DetailsAdapter(@NonNull Context context, ArrayList<pojo> pojo) {
        super(context, 0, pojo);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View listView = convertView;
        if (listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.activity_detail, parent, false);
        }

        pojo currentitem = getItem(position);

        ImageView imageView = (ImageView) listView.findViewById(R.id.backdrop);
        imageView.setImageResource(currentitem.getDetailBackdropID());

        TextView textViewHeader = (TextView) listView.findViewById(R.id.detail_header);
        textViewHeader.setText(currentitem.getDetailHeaderID());

        TextView textViewDetails = (TextView) listView.findViewById(R.id.detail_desc);
        textViewDetails.setText(currentitem.getDetailDescID());

        return listView;
    }
}
