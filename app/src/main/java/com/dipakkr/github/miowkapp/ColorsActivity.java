package com.dipakkr.github.miowkapp;

import android.media.MediaActionSound;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends Fragment {



    private MediaPlayer.OnCompletionListener mCompletionListener =  new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaplayer();
        }
    };

    private MediaPlayer mMediaPlayer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_colors, container, false);


        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.colorPrimary);

        ListView listViewcolor = (ListView) rootview.findViewById(R.id.list_color_view);

        listViewcolor.setAdapter(adapter);

        listViewcolor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = words.get(i);
                releaseMediaplayer();
                mMediaPlayer = MediaPlayer.create(getActivity(), word.getmAudioResourceId());
                mMediaPlayer.start();


                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

        return rootview;

    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaplayer();
    }

    public void releaseMediaplayer(){
        if (mMediaPlayer != null){

            mMediaPlayer.release();

            mMediaPlayer = null ;
        }
    }
}