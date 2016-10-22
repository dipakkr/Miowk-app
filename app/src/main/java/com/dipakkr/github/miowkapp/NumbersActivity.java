package com.dipakkr.github.miowkapp;

import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class NumbersActivity extends Fragment{

    private MediaPlayer.OnCompletionListener mCompletionListener =  new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private MediaPlayer mMediaPlayer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.activity_numbers,container,false);


        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("One", "Lutti", R.drawable.number_one,R.raw.number_one));
        words.add(new Word("Two", "Lutti", R.drawable.number_two,R.raw.number_two));
        words.add(new Word("Three", "Lutti", R.drawable.number_three,R.raw.number_three));
        words.add(new Word("Four", "Lutti", R.drawable.number_four,R.raw.number_four));
        words.add(new Word("Five", "Lutti", R.drawable.number_five,R.raw.number_five));
        words.add(new Word("Six", "Lutti", R.drawable.number_five,R.raw.number_six));
        words.add(new Word("Seven", "Lutti", R.drawable.number_six,R.raw.number_seven));
        words.add(new Word("Eight", "Lutti", R.drawable.number_seven,R.raw.number_eight));
        words.add(new Word("Nine", "Lutti", R.drawable.number_eight,R.raw.number_nine));
        words.add(new Word("Ten", "Lutti", R.drawable.number_nine,R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.colorPrimaryDark);

        ListView numberslistview = (ListView) view.findViewById(R.id.listview);

        numberslistview.setAdapter(adapter);

        numberslistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);

                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(getActivity(), word.getmAudioResourceId());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

        return view;
    }



    // onstop method will immediately stop the sound if during playing activity is paused

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {

            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

        }
    }
 }
