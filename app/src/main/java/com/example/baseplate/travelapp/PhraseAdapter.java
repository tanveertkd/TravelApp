package com.example.baseplate.travelapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PhraseAdapter extends ArrayAdapter<pojo> {
    public PhraseAdapter(@NonNull Context context, ArrayList<pojo> pojo) {
        super(context, 0, pojo);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View phraseListView = convertView;
        if(phraseListView == null) {
            phraseListView = LayoutInflater.from(getContext()).inflate(R.layout.phrase_items, parent, false);
        }

        final pojo currentitem = getItem(position);

        TextView phrase = (TextView) phraseListView.findViewById(R.id.phrase_name);
        phrase.setText(currentitem.getPhraseID());

        TextView phraseMeaning = (TextView) phraseListView.findViewById(R.id.phrase_meaning);
        phraseMeaning.setText(currentitem.getPhraseMeaningID());

        TextView play = (TextView) phraseListView.findViewById(R.id.phrase_play);
        play.setText(currentitem.getPlayID());

        return phraseListView;
    }
}
