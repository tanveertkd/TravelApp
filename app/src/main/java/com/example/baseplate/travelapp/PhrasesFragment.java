package com.example.baseplate.travelapp;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public PhrasesFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.item_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<pojo> pojoArrayList = new ArrayList<pojo>();
        pojoArrayList.add(new pojo(getString(R.string.phrase_one), getString(R.string.phrase_one_meaning), getString(R.string.play), R.raw.hello));
        pojoArrayList.add(new pojo(getString(R.string.phrase_two), getString(R.string.phrase_two_meaning), getString(R.string.play), R.raw.thankyou));
        pojoArrayList.add(new pojo(getString(R.string.phrase_three), getString(R.string.phrase_three_meaning), getString(R.string.play), R.raw.yes));
        pojoArrayList.add(new pojo(getString(R.string.phrase_four), getString(R.string.phrase_four_meaning), getString(R.string.play), R.raw.sorry));
        pojoArrayList.add(new pojo(getString(R.string.phrase_five), getString(R.string.phrase_five_meaning), getString(R.string.play), R.raw.please));
        pojoArrayList.add(new pojo(getString(R.string.phrase_six), getString(R.string.phrase_six_meaning), getString(R.string.play), R.raw.no));
        pojoArrayList.add(new pojo(getString(R.string.phrase_seven), getString(R.string.phrase_seven_meaning), getString(R.string.play), R.raw.howmuch));
        pojoArrayList.add(new pojo(getString(R.string.phrase_eight), getString(R.string.phrase_eight_meaning), getString(R.string.play), R.raw.goodbye));
        pojoArrayList.add(new pojo(getString(R.string.phrase_nine), getString(R.string.phrase_nine_meaning), getString(R.string.play), R.raw.excuse));
        pojoArrayList.add(new pojo(getString(R.string.phrase_ten), getString(R.string.phrase_ten_meaning), getString(R.string.play), R.raw.doc));
        pojoArrayList.add(new pojo(getString(R.string.phrase_eleven), getString(R.string.phrase_eleven_meaning), getString(R.string.play), R.raw.check));
        pojoArrayList.add(new pojo(getString(R.string.phrase_twelve), getString(R.string.phrase_twelve_meaning), getString(R.string.play), R.raw.bathroom));

        PhraseAdapter adapter = new PhraseAdapter(getActivity(), pojoArrayList);
        ListView listViewItems = (ListView) rootView.findViewById(R.id.list);
        listViewItems.setAdapter(adapter);

        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();

                pojo pojo = pojoArrayList.get(position);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), pojo.getAudioResourceID());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
