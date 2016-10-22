package com.dipakkr.github.miowkapp;

/**
 * Created by deepak on 18-10-2016.
 */

public class Word{

    private String mDefaultTranslation ;
    private String mMiwokTranslation ;
    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId ;



    public Word(String DefaultTranslation, String MiwokTranslation, int Imagesourceid,int AudioResourceId){
        mDefaultTranslation = DefaultTranslation ;
        mMiwokTranslation = MiwokTranslation ;
        mImageResourceId = Imagesourceid;
        mAudioResourceId = AudioResourceId ;

    }
    public Word(String DefaultTranslation, String MiwokTranslation,int AudioResourceId){
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResourceId = AudioResourceId ;

    }

    public String getmDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation(){
        return  mMiwokTranslation ;
    }
    public int  getmImagesourceid(){
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    public int getmImageResourceId(){
        return mImageResourceId ;
    }

    public int getmAudioResourceId(){
        return mAudioResourceId;
    }
}
