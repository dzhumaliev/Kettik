package com.kg.kettik.models;

public class OnBoardModel {

    String title;
    String desc;
    String image;

    public OnBoardModel(String title, String desc, String image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage() {
        return image;
    }
}
