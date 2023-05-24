package com.kg.kettik.models;

import java.util.ArrayList;
import java.util.List;

public class ToursDetailModel {

    private String title;
    private String miniTitle;
    private String price;
    private ArrayList<String> bringCharacteristics;
    private String fullDescription;
    private String date;
    private String day;
    private String image;
    private String image2;
    private String image3;
    private String image4;
    public ToursDetailModel(String title, String miniTitle, String price, ArrayList<String> bringCharacteristics, String fullDescription, String date, String day, String image, String image2, String image3, String image4) {
        this.title = title;
        this.miniTitle = miniTitle;
        this.price = price;
        this.bringCharacteristics = bringCharacteristics;
        this.fullDescription = fullDescription;
        this.date = date;
        this.day = day;
        this.image = image;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMiniTitle() {
        return miniTitle;
    }

    public void setMiniTitle(String miniTitle) {
        this.miniTitle = miniTitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ArrayList<String> getBringCharacteristics() {
        return bringCharacteristics;
    }

    public void setBringCharacteristics(ArrayList<String> bringCharacteristics) {
        this.bringCharacteristics = bringCharacteristics;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getImage() {
        return image;
    }

    public void setImage1(String image) {
        this.image = image;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }





}
