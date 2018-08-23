package com.example.baseplate.travelapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
public class HotelsAdapter extends ArrayAdapter<pojo>{
    private Context mContext;
    public HotelsAdapter(@NonNull Context context, ArrayList<pojo> pojo) {
        super(context, 0, pojo);
        this.mContext=context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.hotel_items, parent, false);
        }
        final pojo currentItem = getItem(position);

        ImageView backgroundImage = (ImageView) listView.findViewById(R.id.category_image);
        backgroundImage.setImageResource(currentItem.getImageResource());

        TextView categoryHeader = (TextView) listView.findViewById(R.id.category_header);
        categoryHeader.setText(currentItem.getHeaderResource());

        View categoryGradient  = (View) listView.findViewById(R.id.grad);
        categoryGradient.setBackgroundResource(currentItem.getGradientResource());

        ImageView locationIcon = (ImageView) listView.findViewById(R.id.location_icon);
        locationIcon.setImageResource(currentItem.getLocationIconID());

        TextView addressView = (TextView) listView.findViewById(R.id.location_data);
        addressView.setText(currentItem.getAddressID());

        ImageView phoneIcon = (ImageView) listView.findViewById(R.id.phone_icon);
        phoneIcon.setImageResource(currentItem.getPhoneIconID());

        TextView phoneView = (TextView) listView.findViewById(R.id.phone_data);
        phoneView.setText(currentItem.getPhoneID());

        LinearLayout locationLayout = (LinearLayout) listView.findViewById(R.id.location_layout);
        locationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("geo:0,0?q=" + currentItem.getAddressID()));
                mContext.startActivity(geoIntent);
            }
        });

        LinearLayout phoneLayout = (LinearLayout) listView.findViewById(R.id.phone_layout);
        phoneLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: " + currentItem.getPhoneID()));
                mContext.startActivity(callIntent);
            }
        });

        return listView;
    }
}
