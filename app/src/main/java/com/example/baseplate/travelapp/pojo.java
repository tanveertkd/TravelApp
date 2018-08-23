package com.example.baseplate.travelapp;

public class pojo {
    private int imageID;
    private String headerID;
    private int gradientID;

    private int locationIconID;
    private String addressID;
    private int phoneIconID;
    private String phoneID;

    private int mAudioResourceID;
    private String mPhraseID;
    private String mPlay;
    private String mPhraseMeaning;

    public pojo(String headerResourceID, int imageResourceID, int gradientResourceID, int locationIconResourceID, String addressResourceID, int phoneIconResourceID, String phoneResourceID){
        headerID = headerResourceID;
        imageID = imageResourceID;
        gradientID = gradientResourceID;
        locationIconID = locationIconResourceID;
        addressID = addressResourceID;
        phoneIconID = phoneIconResourceID;
        phoneID = phoneResourceID;
    }

    public pojo(String phraseID, String phraseMeaningID, String playID, int audioResourceID){
        mAudioResourceID = audioResourceID;
        mPhraseID = phraseID;
        mPhraseMeaning = phraseMeaningID;
        mPlay = playID;
    }

    public int getImageResource(){
        return imageID;
    }
    public int getGradientResource(){
        return gradientID;
    }
    public String getHeaderResource() {
        return headerID;
    }

    public int getLocationIconID() {
        return locationIconID;
    }

    public String getAddressID() {
        return addressID;
    }

    public int getPhoneIconID() {
        return phoneIconID;
    }

    public String getPhoneID() {
        return phoneID;
    }

    public int getAudioResourceID(){
        return mAudioResourceID;
    }

    public String  getPhraseID(){
        return mPhraseID;
    }

    public String getPhraseMeaningID() {
        return mPhraseMeaning;
    }

    public String getPlayID(){
        return mPlay;
    }
}
