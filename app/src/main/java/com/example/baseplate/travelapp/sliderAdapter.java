package com.example.baseplate.travelapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class sliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public sliderAdapter(Context context){
        this.context = context;
    }

    public int[] images = {
            R.drawable.ic_utensils_solid,
            R.drawable.ic_bed_solid,
            R.drawable.ic_fort_awesome_alt_brands_monuments_castle
    };

    public String[] heading = {
            "Restaurants",
            "Hotels",
            "Attractions"
    };

    public String[] desc = {
            "Get the best food.",
            "Get the best hotels around.",
            "Most recommended tourist Spots"
    };

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView sliderImageView = (ImageView) view.findViewById(R.id.imageView);
        TextView sliderHead = (TextView) view.findViewById(R.id.heading);
        TextView sliderDesc = (TextView) view.findViewById(R.id.desc);

        sliderImageView.setImageResource(images[position]);
        sliderHead.setText(heading[position]);
        sliderDesc.setText(desc[position]);

        container.addView(view);

        return view;
    };

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
