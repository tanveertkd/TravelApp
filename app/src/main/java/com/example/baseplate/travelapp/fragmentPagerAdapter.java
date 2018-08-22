package com.example.baseplate.travelapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class fragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public fragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HotelsFragment();
        } else if (position == 1) {
            return new RestaurentsFragments();
        } else if (position == 2) {
            return new PlacesFragment();
        } else if (position == 3) {
            return new PoliceFragment();
        }  else if (position == 4) {
            return new PhrasesFragment();
        } else {
            return new TrainFragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.hotels_head);
        } else if (position == 1) {
            return mContext.getString(R.string.restaurant_head);
        } else if (position == 2) {
            return mContext.getString(R.string.places_head);
        } else if (position == 3) {
            return mContext.getString(R.string.police_head);
        }  else if (position == 4) {
            return mContext.getString(R.string.phrases_head);
        } else {
            return mContext.getString(R.string.train_head);
        }
    }
}
