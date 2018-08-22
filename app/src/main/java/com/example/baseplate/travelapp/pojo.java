package com.example.baseplate.travelapp;

public class pojo {
    private int imageID;
    private String headerID;
    private int gradientID;

    private String detailHeaderID;
    private String detailDescID;
    private int detailBackdropID;

    public pojo(String headerResourceID, int imageResourceID, int gradientResourceID){
        headerID = headerResourceID;
        imageID = imageResourceID;
        gradientID = gradientResourceID;
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

    public String getDetailHeaderID() {
        return detailHeaderID;
    }

    public String getDetailDescID() {
        return detailDescID;
    }

    public int getDetailBackdropID() {
        return detailBackdropID;
    }
}
