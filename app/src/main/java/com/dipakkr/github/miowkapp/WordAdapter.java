package com.dipakkr.github.miowkapp;

import android.app.Activity;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by deepak on 18-10-2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResoureId ;

    public WordAdapter(Activity context, ArrayList<Word> words,int ColorResourceId){
        super(context,0,words);
        mColorResoureId = ColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Word word = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.number_list_items,parent,false);
        }

        TextView upperword = (TextView)convertView.findViewById(R.id.default_text_view);
        upperword.setText(word.getmDefaultTranslation());

        TextView lowerword = (TextView)convertView.findViewById(R.id.miwok_text_view);
        lowerword.setText(word.getmMiwokTranslation());

        ImageView imageView = (ImageView)convertView.findViewById(R.id.image);

        if(word.hasImage()){
            imageView.setImageResource(word.getmImagesourceid());
            imageView.setVisibility(View.VISIBLE);
        }else
        {
          imageView.setVisibility(View.GONE);
        }
         // Reference for the linear layout of both translation
        View textContainer = convertView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(),mColorResoureId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return convertView;

    }
}
